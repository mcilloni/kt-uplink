/*
 *  uplink, a simple daemon to implement a simple chat protocol
 *  Copyright (C) Marco Cilloni <marco.cilloni@yahoo.com> 2016
 *
 *  This Source Code Form is subject to the terms of the Mozilla Public
 *  License, v. 2.0. If a copy of the MPL was not distributed with this
 *  file, You can obtain one at http://mozilla.org/MPL/2.0/.
 *  Exhibit B is not attached; this software is compatible with the
 *  licenses expressed under Section 1.12 of the MPL v2.
 *
 */

@file:JvmName("Uplink")
@file:JvmMultifileClass

package com.github.mcilloni.uplink

import com.github.mcilloni.uplink.nano.UplinkGrpc
import com.github.mcilloni.uplink.nano.UplinkProto
import com.github.mcilloni.uplink.nano.UplinkProto.Notification
import io.grpc.ManagedChannelBuilder
import io.grpc.Metadata
import io.grpc.stub.MetadataUtils
import io.grpc.stub.StreamObserver
import java.util.concurrent.ExecutionException

internal class Stubs(astub: UplinkGrpc.UplinkStub, bstub: UplinkGrpc.UplinkBlockingStub) {
    var asyncStub = astub
        private set

    var blockingStub = bstub
        private set

    fun setSessionInfo(uid: Long, sessid: String) {
        val metadata = Metadata()
        metadata.put(Metadata.Key.of("uid", Metadata.ASCII_STRING_MARSHALLER), uid.toString())
        metadata.put(Metadata.Key.of("sessid", Metadata.ASCII_STRING_MARSHALLER), sessid)

        this.asyncStub = MetadataUtils.attachHeaders(this.asyncStub, metadata)
        this.blockingStub = MetadataUtils.attachHeaders(this.blockingStub, metadata)
    }
}

private fun connect(url: String, port: Int) : Stubs {
    val chan = ManagedChannelBuilder.forAddress(url, port).usePlaintext(true).build()

    val blocking = UplinkGrpc.newBlockingStub(chan)
    val async = UplinkGrpc.newStub(chan)

    return Stubs(async, blocking)
}

data class Session(val uid: Long, val sessid: String)

fun login(url: String, port: Int, userName: String, authPass: String) = try {
    val stubs = connect(url, port)

    val info = stubs.blockingStub.login(with(UplinkProto.AuthInfo()) {
        name = userName
        pass = authPass

        this
    })

    val session = Session(info.uid, info.sessionId)

    UplinkConnection(stubs, session, userName)
} catch (e: ExecutionException) {
    throw normExc(e.cause ?: throw e)
}

fun newUser(url: String, port: Int, userName: String, authPass: String) = try {
    val stubs = connect(url, port)

    val existsResp = stubs.blockingStub.exists(with(UplinkProto.Name()) {
        name = userName

        this
    })

    if (existsResp.success) {
        throw NameAlreadyTakenException()
    }

    val resp = stubs.blockingStub.newUser(with(UplinkProto.AuthInfo()) {
        name = userName
        pass = authPass

        this
    })

    UplinkConnection(stubs, Session(resp.uid, resp.sessionId), userName)
} catch (e: ExecutionException) {
    throw normExc(e.cause ?: throw e)
}

fun resumeSession(url: String, port: Int, name: String, sessInfo: Session) = try {
    val stubs = connect(url, port)

    UplinkConnection(stubs, sessInfo, name)
} catch (e: ExecutionException) {
    throw normExc(e.cause ?: throw e)
}

interface NotificationHandler {
    fun onNewMessage(message: Message)
    fun onFriendRequest(userName: String)
    fun onNewFriendship(userName: String)
    fun onConversationInvite(conversationInvite: ConversationInvite)
    fun onNewUserInConversation(userName: String, conv: Conversation)
    fun onServerReady()
    fun onError(t: Throwable)
}

class UplinkConnection internal constructor(private val stubs: Stubs, val sessInfo: Session, val username: String) {
    init {
        stubs.setSessionInfo(sessInfo.uid, sessInfo.sessid)
    }

    fun acceptFriendshipWith(name: String) = rpc {
        stubs.blockingStub.acceptFriendship(with(UplinkProto.Name()) {
            this.name = name

            this
        }).success
    }

    fun acceptInvite(convID: Long) = rpc {
        stubs.blockingStub.acceptInvite(with(UplinkProto.ID()) {
            this.id = convID

            this
        }).success
    }

    fun beginConversation(name: String) = rpc {
        Conversation(name, stubs.blockingStub.newConversation(with(UplinkProto.Name()) {
            this.name = name

            this
        }).id)
    }

    fun getConversations() = rpc {
        stubs.blockingStub.conversations(UplinkProto.Empty()).convs.map {
            Conversation(it.name, it.id)
        }
    }

    fun getFriends() = rpc {
        stubs.blockingStub.friends(UplinkProto.Empty()).friends
    }

    fun getFriendshipRequests() = rpc {
        stubs.blockingStub.receivedRequests(UplinkProto.Empty()).friends
    }

    fun getInvites() = rpc {
        stubs.blockingStub.invites(UplinkProto.Empty()).invites.map {
            Invite(fromUser = it.who, toConv = it.convName, convID = it.convId)
        }
    }

    fun ping() = rpc {
        stubs.blockingStub.ping(UplinkProto.Empty()).success
    }

    fun sendFriendshipRequest(user: String) = rpc {
        stubs.blockingStub.requestFriendship(with(UplinkProto.Name()){
            name = user

            this
        }).success
    }

    fun sendInvite(user: String, convID: Long) = rpc {
        stubs.blockingStub.sendInvite(with(UplinkProto.Invite()){
            who = user
            convId = convID

            this
        }).success
    }

    infix fun subscribe (handl: NotificationHandler) {
        stubs.asyncStub.notifications(UplinkProto.Empty(), object : StreamObserver<UplinkProto.Notification> {
            override fun onError(t: Throwable?) {
                handl.onError(t ?: NullPointerException())
            }

            override fun onCompleted() {}

            override fun onNext(value: UplinkProto.Notification?) {
                if (value != null) {
                    with (value) {
                        when (type) {
                            Notification.HANDLER_READY -> {
                                handl.onServerReady()
                            }

                            Notification.MESSAGE -> {
                                handl.onNewMessage(Message(userName, convId, body))
                            }

                            Notification.JOIN_REQ -> {
                                handl.onConversationInvite(ConversationInvite(userName, Conversation(convName, convId)))
                            }

                            Notification.JOIN_ACC -> {
                                handl.onNewUserInConversation(userName, Conversation(convName, convId))
                            }

                            Notification.FRIENDSHIP_REQ -> {
                                handl.onFriendRequest(userName)
                            }

                            Notification.FRIENDSHIP_ACC -> {
                                handl.onNewFriendship(userName)
                            }
                        }
                    }
                }
            }

        })
    }
}