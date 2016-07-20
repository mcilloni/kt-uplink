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

open class Conversation internal constructor (val name: String, val convID: Long,
                                              private val connection: UplinkConnection, firstMsg: Message? = null) {

    internal constructor(netConv: UplinkProto.Conversation, conn: UplinkConnection)
        : this(
            name = netConv.name,
            convID = netConv.id,
            connection = conn,
            firstMsg = if (netConv.lastMessage != null) Message(netConv.id, netConv.lastMessage) else null
        )

    private var cached = ArrayList<Message>(20)
    private var lastTag = 0L

    init {
        if (firstMsg != null) {
            cached.add(firstMsg)
            lastTag = firstMsg.tag
        }
    }

    fun next() : List<Message> {
        val next = getMessages(lastTag)

        if (next.size > 0) {
            lastTag = next.first().tag

            cached.addAll(0, next)
        }

        return cached
    }

    fun update() : List<Message> {
        if (lastTag == 0L) {
            return next()
        }

        val newMsgs = ArrayList<Message>(20)
        var last = 0L
        do {
            val messages = getMessages(last)
            newMsgs.addAll(0, messages)
            last = newMsgs.first().tag
        } while(last <= lastTag)

        cached = newMsgs
        return cached
    }

    protected fun getMessages(lastTag : Long = 0) = rpc {
        connection.stubs.blockingStub.messages(with(UplinkProto.FetchOpts()) {
            this.convId = convID
            this.lastTag = lastTag

            this
        }).messages.map {
            Message(convID, it)
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

    override fun toString(): String{
        return "Conversation(name='$name', convID=$convID, cached=$cached)"
    }

    val lastMessage : Message?
        get() = try {
            cached.last()
        } catch(e: NoSuchElementException) {
            null
        }
}