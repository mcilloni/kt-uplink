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

import com.github.mcilloni.uplink.UplinkConnection
import com.github.mcilloni.uplink.login
import com.github.mcilloni.uplink.newUser
import org.junit.Test as test
import org.junit.Assert.*
import org.junit.FixMethodOrder
import org.junit.runners.MethodSorters
import java.math.BigInteger
import java.security.MessageDigest
import java.util.*

const val URL = "localhost"
const val PORT = 4444
const val N_USERS = 1

data class UInfo(val name: String = genRandStr(), val authPass: String = genRandStr(), val keyPass: String = genRandStr())

val users = (1..N_USERS).map { UInfo() }

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
    var conn: UplinkConnection? = null

    @test fun testANewUser() {
        for (uinfo in users) {
            println("new $uinfo")

            val conn = newUser(URL, PORT, uinfo.name, uinfo.authPass, uinfo.keyPass)

            assert(conn.ping())

            println(conn.sessInfo)

            val d = MessageDigest.getInstance("sha-256")
            d.update(conn.user.keyPair.private.encoded)
            println("priv_hash = ${BigInteger(d.digest()).toString(16)}")
        }
    }

    @test fun testBLogin() {
        for (uinfo in users) {
            println("login as $uinfo")

            conn = login(URL, PORT, uinfo.name, uinfo.authPass, uinfo.keyPass)

            assert(conn?.ping() == true)

            println(conn?.sessInfo)
        }
    }
}