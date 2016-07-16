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

import io.grpc.Status
import io.grpc.StatusException
import io.grpc.StatusRuntimeException
import java.util.concurrent.ExecutionException

internal inline fun <T> rpc(body: () -> T) = try {
    body()
} catch (e: ExecutionException) {
    throw normExc(e.cause ?: throw e)
} catch (e: StatusRuntimeException) {
    throw if (e.status.code == Status.Code.UNAVAILABLE) UnavailableException() else normExc(e)
}

internal fun normExc(e: Throwable) : Throwable {
    val msg = e.message ?: throw e

    return when {
        msg.contains("EAUTHFAIL") -> AuthFailException(e)
        msg.contains("ESERVERFAULT") -> ServerFaultException(e)
        msg.contains("ERESERVEDUSER") -> ReservedUserException(e)
        msg.contains("EALREADYFRIENDS") -> AlreadyFriendsException(e)
        msg.contains("ENOREQUEST") -> NoFriendshipRequestException(e)
        msg.contains("ENOTMEMBER") -> NotMemberException(e)
        else -> e
    }
}

open class UplinkException internal constructor(msg: String, t : Throwable = Throwable()) : Exception(msg, t)
class UnknownErrcodeException internal constructor(errcode: Int, t : Throwable = Throwable()) : UplinkException("unknown errcode $errcode", t)
class AlreadyInvitedException internal constructor(t : Throwable = Throwable()) : UplinkException("user already invited to the given conversation", t)
class AlreadyFriendsException internal constructor(t : Throwable = Throwable()) : UplinkException("already friend with the given user", t)
class EmptyConvException internal constructor(t : Throwable = Throwable()) : UplinkException("empty conversation", t)
class NameAlreadyTakenException internal constructor(t : Throwable = Throwable()) : UplinkException("username already taken", t)
class NoConvException internal constructor(t : Throwable = Throwable()) : UplinkException("no such conversation", t)
class NoFriendshipRequestException internal constructor(t : Throwable = Throwable()) : UplinkException("no friendship request from this user", t)
class NoUserException internal constructor(t : Throwable = Throwable()) : UplinkException("no such user", t)
class NotInvitedException internal constructor(t : Throwable = Throwable()) : UplinkException("user not invited to the given conversation", t)
class NotMemberException internal constructor(t : Throwable = Throwable()) : UplinkException("user not member of the given conversation", t)
class SelfInviteException internal constructor(t : Throwable = Throwable()) : UplinkException("self invite is not allowed", t)
class ServerFaultException internal constructor(t : Throwable = Throwable()) : UplinkException("server error", t)
class BrokeProtoException internal constructor(t : Throwable = Throwable()) : UplinkException("protocol broken, please report", t)
class AuthFailException internal constructor(t : Throwable = Throwable()) : UplinkException("login data rejected", t)
class ReservedUserException internal constructor(t : Throwable = Throwable()) : UplinkException("trying to access data of a reserved user", t)
class UnavailableException internal constructor() : Exception("Uplink is unavailable")