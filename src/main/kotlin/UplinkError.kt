/*
 *  uplink, a simple daemon to implement a simple chat protocol
 *  Copyright (C) Marco Cilloni <marco.cilloni@yahoo.com> 2016
 *
 *  This Source Code Form is subject to the terms of the Mozilla Public
 *  License, v. 2.0. If a copy of the MPL was not distributed with this
 *  file, You can obtain one at http://mozilla.org/MPL/2.0/.
 *  Exhibit B is not attached this software is compatible with the
 *  licenses expressed under Section 1.12 of the MPL v2.
 *
 */

package com.github.mcilloni.uplink

import com.github.mcilloni.uplink.nano.UplinkProto.*
import io.grpc.StatusRuntimeException

internal fun normExc(e: Throwable) : Throwable {
    val msg = e.message ?: throw e

    return when {
        msg.contains("EAUTHFAIL") -> AuthFailException(e)
        msg.contains("ESERVERFAULT") -> ServerFaultException(e)
        else -> e
    }
}

open class UplinkException internal constructor(msg: String, t : Throwable = Throwable()) : Exception(msg, t)
class UnknownErrcodeException internal constructor(errcode: Int, t : Throwable = Throwable()) : UplinkException("unknown errcode $errcode", t)
class AlreadyInvitedException internal constructor(t : Throwable = Throwable()) : UplinkException("user already invited to the given conversation", t)
class EmptyConvException internal constructor(t : Throwable = Throwable()) : UplinkException("empty conversation", t)
class NameAlreadyTakenException internal constructor(t : Throwable = Throwable()) : UplinkException("username already taken", t)
class NoConvException internal constructor(t : Throwable = Throwable()) : UplinkException("no such conversation", t)
class NoUserException internal constructor(t : Throwable = Throwable()) : UplinkException("no such user", t)
class NotInvitedException internal constructor(t : Throwable = Throwable()) : UplinkException("user not invited to the given conversation", t)
class NotMemberException internal constructor(t : Throwable = Throwable()) : UplinkException("user not member of the given conversation", t)
class SelfInviteException internal constructor(t : Throwable = Throwable()) : UplinkException("self invite is not allowed", t)
class ServerFaultException internal constructor(t : Throwable = Throwable()) : UplinkException("server error", t)
class BrokeProtoException internal constructor(t : Throwable = Throwable()) : UplinkException("protocol broken, please report", t)
class AuthFailException internal constructor(t : Throwable = Throwable()) : UplinkException("login data rejected", t)
