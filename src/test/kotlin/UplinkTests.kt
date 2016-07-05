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
import java.math.BigInteger
import java.security.KeyPair
import java.security.MessageDigest
import java.util.*

const val URL = "localhost"
const val PORT = 4444

data class UInfo(val name: String = genRandStr(), val authPass: String = genRandStr(), val keyPass: String = genRandStr())

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
        var conn: UplinkConnection? = null
        val uinfo = UInfo()
        var sessInfo: Session? = null
        var keyPair: KeyPair? = null
    }

    @test fun testANewUser() {
        println("new $uinfo")

        val conn = newUser(URL, PORT, uinfo.name, uinfo.authPass, uinfo.keyPass)

        assert(conn.ping())
    }

    @test fun testBLogin() {
        println("login as $uinfo")

        conn = login(URL, PORT, uinfo.name, uinfo.authPass, uinfo.keyPass)

        assert(conn?.ping() == true)

        sessInfo = conn?.sessInfo
        println("got session $sessInfo")
        keyPair = conn?.keyPair
    }

    @test fun testCResume() {
        println("resuming session $sessInfo")

        conn = resumeSession(URL, PORT, uinfo.name, keyPair!!, sessInfo!!)

        assert(conn?.ping() == true)
    }
}