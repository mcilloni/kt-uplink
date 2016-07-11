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

class Conversation internal constructor (val name: String, val convID: Long, private val connection: UplinkConnection) {
    fun getMessages(lastTag : Long = 0) = rpc {
        connection.stubs.blockingStub.messages(with(UplinkProto.FetchOpts()) {
            this.convId = convID
            this.lastTag = lastTag

            this
        }).messages.map {
            Message(
                tag = it.tag,
                sender = it.senderName,
                convID = convID,
                body = it.body,
                time = Date(it.timestamp * 1000L)
            )
        }
    }

    fun send(text: String) = rpc {
        connection.stubs.blockingStub.sendMessage(with(UplinkProto.NewMsgReq()) {
            this.convId = convID
            this.body = text

            this
        })

        Unit
    }

    override fun equals(other: Any?): Boolean{
        if (this === other) return true
        if (other?.javaClass != javaClass) return false

        other as Conversation

        if (name != other.name) return false
        if (convID != other.convID) return false
        if (connection != other.connection) return false

        return true
    }

    override fun hashCode(): Int{
        var result = name.hashCode()
        result = 31 * result + convID.hashCode()
        result = 31 * result + connection.hashCode()
        return result
    }
}