package com.kiyotakeshi.library

import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

class PasswordEncodingTest {

    private val password = "1qazxsw2"

    @Test
    @DisplayName("generated same hash using same salt")
    fun testBcrypt() {
        val bcrypt: PasswordEncoder = BCryptPasswordEncoder()
        val bcryptEncode1 = bcrypt.encode(password)
        val bcryptEncode2 = bcrypt.encode(password)
        println("bcrypt encoded password1: $bcryptEncode1")
        println("bcrypt encoded password2: $bcryptEncode2")

        assertNotEquals(bcryptEncode1, bcryptEncode2)
    }
}