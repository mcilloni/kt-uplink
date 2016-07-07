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
import org.junit.Test as test
import org.junit.Assert.*
import org.junit.FixMethodOrder
import org.junit.runners.MethodSorters
import java.util.*

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
}