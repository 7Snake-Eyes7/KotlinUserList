package com.blbz.userlist.util

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.auth0.jwt.exceptions.JWTCreationException
import com.auth0.jwt.exceptions.JWTVerificationException
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.io.UnsupportedEncodingException


@Component
class JwtGenerator {

    val SECRET = "12345"

    fun jwtToken(l: Long): String {
        var token: String = ""
        try {
            token = JWT.create().withClaim("id", l).sign(Algorithm.HMAC512(SECRET))
        } catch (e: IllegalArgumentException) {
            e.printStackTrace()
        } catch (e: JWTCreationException) {
            e.printStackTrace()
        } catch (e: UnsupportedEncodingException) {
            e.printStackTrace()
        }
        return token
    }

    @Throws(JWTVerificationException::class, IllegalArgumentException::class, UnsupportedEncodingException::class)
    fun parseJWT(jwt: String): Long {
        var userId = 0.toLong()
        if (jwt != null) {
            userId = JWT.require(Algorithm.HMAC512(SECRET)).build().verify(jwt).getClaim("id").asLong()
        }
        return userId
    }

}