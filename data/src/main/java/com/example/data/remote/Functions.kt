package com.example.data.remote

import java.math.BigInteger
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

fun getMd5(ts: String): String {
    try {

        val md = MessageDigest.getInstance("MD5")

        val messageDigest = md.digest(ts.toByteArray()
                + Data.PrivateApiKey.title.toByteArray()
                + Data.PublicApiKey.title.toByteArray())

        val no = BigInteger(1, messageDigest)

        var hashText = no.toString(16)
        while (hashText.length < 32) {
            hashText = "0$hashText"
        }
        return hashText
    } catch (e: NoSuchAlgorithmException) {
        throw RuntimeException(e)
    }
}