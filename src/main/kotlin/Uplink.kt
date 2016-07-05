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
import com.google.common.util.concurrent.SettableFuture
import io.grpc.ManagedChannelBuilder
import io.grpc.Metadata
import io.grpc.stub.MetadataUtils
import io.grpc.stub.StreamObserver

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
data class Step1Result(val userInfo: UplinkProto.UserInfo, val challenge: UplinkProto.Challenge)

private class LoginHandler(val futureInfo: SettableFuture<Step1Result>, val futureSess: SettableFuture<Session>) : StreamObserver<UplinkProto.LoginResp> {
    private enum class State {
        STEP1,
        STEP2,
        END
    }

    private var state = State.STEP1

    override fun onCompleted() {
        if (state != State.END) {
            throw BrokeProtoException()
        }
    }

    override fun onError(t: Throwable?) {
        futureInfo.setException(t)
        futureSess.setException(t)
    }

    override fun onNext(value: UplinkProto.LoginResp?) {
        val step1 = value?.step1
        val step2 = value?.step2

        when {
            step1 != null -> {
                if (state != State.STEP1) {
                    throw BrokeProtoException()
                }

                futureInfo.set(Step1Result(step1.userInfo, step1.challenge))

                state = State.STEP2
            }

            step2 != null -> {
                if (state != State.STEP2) {
                    throw BrokeProtoException()
                }

                futureSess.set(Session(step2.uid, step2.sessionId))

                state = State.END
            }
        }
    }

}

fun login(url: String, port: Int, userName: String, authPass: String, keyPass: String) : UplinkConnection {
    val stubs = connect(url, port)

    val futureInfo = SettableFuture.create<Step1Result>()
    val futureSession = SettableFuture.create<Session>()

    val reqObserver = stubs.asyncStub.loginExchange(LoginHandler(futureInfo, futureSession))

    val req = UplinkProto.LoginReq()
    req.step1 = with(UplinkProto.AuthInfo()) {
        name = userName
        pass = authPass

        this
    }

    reqObserver.onNext(req)

    val (info, challenge) = futureInfo.get()

    val user = UplinkUser.fromServerInfo(userName, keyPass, info)

    val decrToken = user.decryptRsa(challenge.token)

    req.step2 = with(UplinkProto.Challenge()) {
        token = decrToken

        this
    }

    reqObserver.onNext(req)

    val session = futureSession.get()

    return UplinkConnection(stubs, session, user)
}

fun newUser(url: String, port: Int, name: String, authPass: String, keyPass: String) : UplinkConnection {
    val stubs = connect(url, port)

    val existsReq = UplinkProto.Username()
    existsReq.name = name
    val existsResp = stubs.blockingStub.exists(existsReq)

    if (existsResp.success) {
        throw NameAlreadyTakenException()
    }

    val user = UplinkUser.generateUser(name, keyPass)
    val resp = stubs.blockingStub.newUser(user.toNewUserReq(authPass))

    stubs.setSessionInfo(resp.sessionInfo.uid, resp.sessionInfo.sessionId)

    return UplinkConnection(stubs, Session(resp.sessionInfo.uid, resp.sessionInfo.sessionId), user)
}

class UplinkConnection internal constructor(private val stubs: Stubs, val sessInfo: Session, private val user: UplinkUser) {
    fun ping() : Boolean {
        val resp = stubs.blockingStub.ping(UplinkProto.Empty())

        return resp.success
    }
}