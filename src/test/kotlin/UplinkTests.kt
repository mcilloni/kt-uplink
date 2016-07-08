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

import com.github.mcilloni.uplink.*
import com.google.common.util.concurrent.SettableFuture
import org.junit.Test as test
import org.junit.Assert.*
import org.junit.FixMethodOrder
import org.junit.runners.MethodSorters
import java.util.*
import java.util.concurrent.TimeUnit

const val URL = "localhost"
const val PORT = 4444

data class UInfo(val name: String = genRandStr(), val authPass: String = genRandStr())

private const val characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"

fun genRandStr(): String {
    val text = CharArray(20);
    val rng = Random()

    for (i in 0..text.lastIndex) {
        text[i] = characters[rng.nextInt(characters.length)]
    }

    return String(text);
}

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class UplinkTests {
    companion object {
        var conns = mutableListOf<UplinkConnection?>(null, null)
        val uinfos = listOf(UInfo(), UInfo())

        // for user 0
        var sessInfo: Session? = null

        var recvFriendReq = SettableFuture.create<Unit>()
        var friendWith1 = SettableFuture.create<Unit>()
        var friendWith2 = SettableFuture.create<Unit>()

        var serverReady1 = SettableFuture.create<Unit>()
        var serverReady2 = SettableFuture.create<Unit>()
    }

    @test fun testANewUser() {
        val uinfo = uinfos[0]

        println("new $uinfo")

        val conn = newUser(URL, PORT, uinfo.name, uinfo.authPass)

        assert(conn.ping())
    }

    @test fun testBLogin() {
        val uinfo = uinfos[0]

        println("login as $uinfo")

        val conn = login(URL, PORT, uinfo.name, uinfo.authPass)

        assert(conn.ping() == true)

        sessInfo = conn.sessInfo
        println("got session $sessInfo")
    }

    @test fun testCResume() {
        val uinfo = uinfos[0]

        println("resuming session $sessInfo")

        conns[0] = resumeSession(URL, PORT, uinfo.name, sessInfo!!)

        assert(conns[0]?.ping() == true)
    }

    @test fun testDSecondUser() {
        val uinfo = uinfos[1]

        println("new $uinfo")

        conns[1] = newUser(URL, PORT, uinfo.name, uinfo.authPass)

        assert(conns[1]?.ping() == true)
    }

    @test fun testESetupListeners() {
        conns[0]?.subscribe(object : NotificationHandler {
            override fun onError(t: Throwable) {
                fail(t.message)
            }

            override fun onServerReady() {
                println("server ready for 1")

                serverReady1.set(null)
            }

            override fun onNewMessage(message: Message) {}

            override fun onFriendRequest(userName: String) {}

            override fun onNewFriendship(userName: String) {
                println("1 now friend with $userName")

                friendWith2.set(null)
            }

            override fun onConversationInvite(conversationInvite: ConversationInvite) {}

            override fun onNewUserInConversation(userName: String, conv: Conversation) {}

        })

        conns[1]?.subscribe(object : NotificationHandler {
            override fun onError(t: Throwable) {
                fail(t.toString())
            }

            override fun onServerReady() {
                println("server ready for 2")

                serverReady2.set(null)
            }

            override fun onNewMessage(message: Message) {}

            override fun onNewUserInConversation(userName: String, conv: Conversation) {}

            override fun onFriendRequest(userName: String) {
                println("friendship request from $userName")

                recvFriendReq.set(null)

                val pendingRequests = conns[1]?.getFriendshipRequests().orEmpty()

                println("pending: [${pendingRequests.joinToString()}]")

                assert(userName in pendingRequests)

                println("accepting now the friendship request from $userName")
                conns[1]?.acceptFriendshipWith(userName)
            }

            override fun onNewFriendship(userName: String) {
                println("2 now friend with $userName")

                friendWith1.set(null)
            }

            override fun onConversationInvite(conversationInvite: ConversationInvite) {}

        })
    }

    @test fun testFRequestFriendship() {
        serverReady1.get(2, TimeUnit.SECONDS)
        serverReady2.get(2, TimeUnit.SECONDS)

        conns[0]?.sendFriendshipRequest(uinfos[1].name)
    }

    @test fun testGCheckFriends() {
        recvFriendReq.get(2, TimeUnit.SECONDS)
        friendWith1.get(2, TimeUnit.SECONDS)
        friendWith2.get(2, TimeUnit.SECONDS)

        assert(uinfos[1].name in conns[0]?.getFriends().orEmpty())
        assert(uinfos[0].name in conns[1]?.getFriends().orEmpty())

    }
}