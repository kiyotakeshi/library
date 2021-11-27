package com.kiyotakeshi.library.domain

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.test.context.TestConstructor

@DataJpaTest
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
internal class UserTest(
    private var em: TestEntityManager
) {
    @Test
    internal fun mapping() {
        val user = User(email = "test@example.com", password = "1qazxsw2", name = "mike", roleType = RoleType.ROLE_USER)
        em.persistAndFlush(user)
    }
}
