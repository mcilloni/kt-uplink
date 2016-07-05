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

package com.github.mcilloni.uplink

import com.github.mcilloni.uplink.nano.UplinkProto
import java.security.*
import java.security.spec.MGF1ParameterSpec
import java.security.spec.PKCS8EncodedKeySpec
import java.security.spec.X509EncodedKeySpec
import javax.crypto.Cipher
import javax.crypto.SecretKey
import javax.crypto.SecretKeyFactory
import javax.crypto.spec.*

internal const val RSA_KEY_STRENGHT = 2048
internal const val AES_KEY_STRENGHT = 128
internal const val GCM_IV_LENGHT = 12
internal const val GCM_IV_LENGHT_BITS = GCM_IV_LENGHT * 8
internal const val PBKDF2_ITERATIONS = 5000
internal const val GCM_AAD_LENGTH_BITS = 128

private fun deriveAESKey(pass: String, salt: ByteArray): SecretKey {
    val pbkdfFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1")
    val keySpec = PBEKeySpec(pass.toCharArray(), salt, PBKDF2_ITERATIONS, AES_KEY_STRENGHT)
    val derivedKey = pbkdfFactory.generateSecret(keySpec)

    return SecretKeySpec(derivedKey.encoded, "AES")
}

private data class EncryptedBytes(val msg: ByteArray, val iv: ByteArray)

private fun SecretKey.cipherGCM(msg: ByteArray, aad: ByteArray): EncryptedBytes {
    val cipher = Cipher.getInstance("AES/GCM/NoPadding")

    val iv = ByteArray(GCM_IV_LENGHT)
    SecureRandom().nextBytes(iv)

    val spec = GCMParameterSpec(GCM_AAD_LENGTH_BITS, iv)

    cipher.init(Cipher.ENCRYPT_MODE, this, spec)
    cipher.updateAAD(aad)

    val encryptedMsg = cipher.doFinal(msg)

    return EncryptedBytes(encryptedMsg, iv)
}

private fun SecretKey.decipherGCM(encMsg: ByteArray, aad: ByteArray, iv: ByteArray): ByteArray {
    val cipher = Cipher.getInstance("AES/GCM/NoPadding")

    val spec = GCMParameterSpec(GCM_AAD_LENGTH_BITS, iv)

    cipher.init(Cipher.DECRYPT_MODE, this, spec)
    cipher.updateAAD(aad)

    val msg = cipher.doFinal(encMsg)

    return msg
}

class UplinkUser private constructor(val name: String, val keyPair: KeyPair, val keyIv: ByteArray,
                                     val keySalt: ByteArray, val encPrivKey: ByteArray) {

    companion object Factory {
        fun fromServerInfo(name: String, keyPass: String, userInfo: UplinkProto.UserInfo): UplinkUser {
            val mainKey = deriveAESKey(keyPass, userInfo.keySalt)

            val rsaKeyFactory = KeyFactory.getInstance("RSA")
            val publicKey = rsaKeyFactory.generatePublic(X509EncodedKeySpec(userInfo.publicKey))

            val privateKey = rsaKeyFactory.generatePrivate(PKCS8EncodedKeySpec(
                    mainKey.decipherGCM(userInfo.encPrivateKey, name.toByteArray(), userInfo.keyIv)
            ))

            val keyPair = KeyPair(publicKey, privateKey)

            return UplinkUser(name, keyPair, userInfo.keyIv, userInfo.keySalt, userInfo.encPrivateKey)
        }

        fun generateUser(name: String, pass: String): UplinkUser {
            val keyPairGen = KeyPairGenerator.getInstance("RSA")
            keyPairGen.initialize(RSA_KEY_STRENGHT)
            val keyPair = keyPairGen.genKeyPair()

            val keySalt = ByteArray(32)
            SecureRandom().nextBytes(keySalt)

            val mainKey = deriveAESKey(pass, keySalt)

            val (encPrivKey, keyIv) = mainKey.cipherGCM(keyPair.private.encoded, name.toByteArray())

            return UplinkUser(name, keyPair, keyIv, keySalt, encPrivKey)
        }
    }

    fun toNewUserReq(authPass: String): UplinkProto.NewUserReq {
        val newUserReq = UplinkProto.NewUserReq()

        with(newUserReq) {
            name = this@UplinkUser.name
            pass = authPass
            publicKey = keyPair.public.encoded
            encPrivateKey = this@UplinkUser.encPrivKey
            keyIv = this@UplinkUser.keyIv
            keySalt = this@UplinkUser.keySalt
        }

        return newUserReq
    }

    private fun rsaOp(bytes: ByteArray, mode: Int, key: Key) : ByteArray {
        val cipher = Cipher.getInstance("RSA/ECB/OAEPPadding");

        cipher.init(mode, key, OAEPParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, PSource.PSpecified.DEFAULT))

        return cipher.doFinal(bytes)
    }

    internal fun decryptRsa(bytes: ByteArray) = rsaOp(bytes, Cipher.DECRYPT_MODE, keyPair.private)
    internal fun encryptRsa(bytes: ByteArray) = rsaOp(bytes, Cipher.ENCRYPT_MODE, keyPair.public)

}
