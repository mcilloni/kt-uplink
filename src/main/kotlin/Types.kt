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

import java.util.*

data class Message internal constructor (val tag: Long, val sender: String, val convID: Long, val body: String, val time : Date = Date())
data class Invite internal constructor (val fromUser: String, val toConv: String, val convID: Long)
data class ConversationInvite internal constructor (val sender: String, val conv: Conversation)


