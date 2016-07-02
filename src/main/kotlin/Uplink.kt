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

package com.github.mcilloni.uplink

import com.github.mcilloni.uplink.nano.UplinkGrpc
import com.github.mcilloni.uplink.nano.UplinkProto
import io.grpc.ManagedChannelBuilder
import io.grpc.Metadata
import io.grpc.stub.MetadataUtils
import java.security.KeyPair

internal fun connect(url: String, port: Int) =
        UplinkGrpc.newBlockingStub(ManagedChannelBuilder.forAddress(url, port).usePlaintext(true).build())

fun UplinkGrpc.UplinkBlockingStub.setSessionInfo(uid: Long, sessid: String) {
    val metadata = Metadata()
    metadata.put(Metadata.Key.of("uid", Metadata.ASCII_STRING_MARSHALLER), uid.toString())
    metadata.put(Metadata.Key.of("sessid", Metadata.ASCII_STRING_MARSHALLER), sessid)

    MetadataUtils.attachHeaders(this, metadata)
}

data class Session(val uid: Long, val sessid: String)

fun newUser(url: String, port: Int, name: String, authPass: String, keyPass: String) : UplinkConnection {
    val stub = connect(url, port)

    val existsReq = UplinkProto.Username()
    existsReq.name = name
    val existsResp = stub.exists(existsReq)

    if (existsResp.success) {
        throw NameAlreadyTakenException()
    }

    val user = UplinkUser.generateUser(name, keyPass)
    val resp = stub.newUser(user.toNewUserReq(authPass))

    stub.setSessionInfo(resp.sessionInfo.uid, resp.sessionInfo.sessionId)

    return UplinkConnection(stub, Session(resp.sessionInfo.uid, resp.sessionInfo.sessionId), user)
}

class UplinkConnection internal constructor(val stub: UplinkGrpc.UplinkBlockingStub, val sessInfo: Session, private val user: UplinkUser) {

}