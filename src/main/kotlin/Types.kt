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

package com.github.mcilloni.uplink;

import com.github.mcilloni.uplink.nano.UplinkProto
import java.util.*

class Message internal constructor (val tag: Long, val sender: String, val convID: Long, val body: String, val time : Date = Date()) {

    internal constructor(convID: Long, netMsg: UplinkProto.Message)
        : this(
            tag = netMsg.tag,
            sender = netMsg.senderName,
            convID = convID,
            body = netMsg.body,
            time = Date(netMsg.timestamp * 1000L)
        )

    val svcMessage = sender == "uplink"

    override fun toString(): String{
        return "Message(tag=$tag, sender='$sender', convID=$convID, body='$body', time=$time, svcMessage=$svcMessage)"
    }

    override fun equals(other: Any?): Boolean{
        if (this === other) return true
        if (other?.javaClass != javaClass) return false

        other as Message

        if (tag != other.tag) return false
        if (sender != other.sender) return false
        if (convID != other.convID) return false
        if (body != other.body) return false
        if (time != other.time) return false
        if (svcMessage != other.svcMessage) return false

        return true
    }

    override fun hashCode(): Int{
        var result = tag.hashCode()
        result = 31 * result + sender.hashCode()
        result = 31 * result + convID.hashCode()
        result = 31 * result + body.hashCode()
        result = 31 * result + time.hashCode()
        result = 31 * result + svcMessage.hashCode()
        return result
    }

}
data class Invite internal constructor (val fromUser: String, val toConv: String, val convID: Long)
data class ConversationInvite internal constructor (val sender: String, val conv: Conversation)


