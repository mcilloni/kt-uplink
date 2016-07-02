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

open class UplinkException internal constructor(msg: String) : Exception(msg)
class UnknownErrcodeException internal constructor(errcode: Int) : UplinkException("unknown errcode $errcode")
class AlreadyInvitedException internal constructor() : UplinkException("user already invited to the given conversation")
class EmptyConvException internal constructor() : UplinkException("empty conversation")
class NameAlreadyTakenException internal constructor() : UplinkException("username already taken")
class NoConvException internal constructor() : UplinkException("no such conversation")
class NoUserException internal constructor() : UplinkException("no such user")
class NotInvitedException internal constructor() : UplinkException("user not invited to the given conversation")
class NotMemberException internal constructor() : UplinkException("user not member of the given conversation")
class SelfInviteException internal constructor() : UplinkException("self invite is not allowed")
class ServerFaultException internal constructor() : UplinkException("server error")
class BrokeProtoException internal constructor() : UplinkException("protocol broken, please report")
class AuthFailException internal constructor() : UplinkException("login data rejected")
