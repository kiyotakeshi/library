package com.kiyotakeshi.library.domain.entity

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.test.context.TestConstructor
import java.time.LocalDate
import java.time.LocalDateTime

@DataJpaTest
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
internal class BookTest(
    private var em: TestEntityManager
) {
    @Test
    internal fun mapping() {
        val book = Book("aws professional", "kendrick west", LocalDate.of(2021, 11, 20))
        em.persistAndFlush(book)
    }
}
