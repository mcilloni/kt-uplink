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

const val URL = "localhost"
const val PORT = 4444
const val USER1 = "TestUser1"
const val AUTHPWD1 = "User 1 auth password"
const val KEYPWD1 = "User 1 key password"

class UplinkTests {
    var conn : UplinkConnection? = null

    @test fun testNewUser() {
        val conn = newUser(URL, PORT, USER1, AUTHPWD1, KEYPWD1)

        assert(conn.ping())

        println(conn.sessInfo)
    }

    @test fun testLogin() {
        conn = login(URL, PORT, USER1, AUTHPWD1, KEYPWD1)

        assert(conn?.ping() == true)

        println(conn?.sessInfo)
    }
}