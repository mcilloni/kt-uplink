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
import com.google.common.util.concurrent.SettableFuture
import io.grpc.ManagedChannelBuilder
import io.grpc.Metadata
import io.grpc.StatusRuntimeException
import io.grpc.stub.MetadataUtils
import io.grpc.stub.StreamObserver
import java.util.concurrent.ExecutionException
import kotlin.concurrent.thread

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

    val existsResp = stubs.blockingStub.exists(with(UplinkProto.Username()) {
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
    fun onFriendRequest(friendRequest: FriendRequest)
    fun onConversationInvite(conversationInvite: ConversationInvite)
}

class UplinkConnection internal constructor(private val stubs: Stubs, val sessInfo: Session, val username: String) {
    init {
        stubs.setSessionInfo(sessInfo.uid, sessInfo.sessid)
    }

    infix fun subscribe (handl: NotificationHandler) = thread(isDaemon = true) {
         while (true) {
            stubs.asyncStub.notifications(UplinkProto.Empty(), object : StreamObserver<UplinkProto.Notification> {
                override fun onError(t: Throwable?) {}

                override fun onCompleted() {}

                override fun onNext(value: UplinkProto.Notification?) {
                    if (value != null) {
                        with (value) {
                            when (type) {
                                Notification.MESSAGE -> {

                                }

                                Notification.INVITE -> {
                                    handl.onConversationInvite(ConversationInvite(senderName, body, convId))
                                }

                                Notification.FRIENDSHIP -> {
                                    handl.onFriendRequest(FriendRequest(senderName))
                                }
                            }
                        }
                    }
                }

            })
        }
    }

    fun ping() : Boolean {
        return try {
            stubs.blockingStub.ping(UplinkProto.Empty())
        } catch (e: ExecutionException) {
            throw normExc(e.cause ?: throw e)
        }.success
    }
}