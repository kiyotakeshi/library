package com.kiyotakeshi.library.domain.entity

import org.junit.jupiter.api.Test
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.test.context.TestConstructor
import java.time.LocalDate

@DataJpaTest
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
internal class AuthorTest(
    private var em: TestEntityManager
) {
    @Test
    internal fun mapping() {
        val author1 = Author("yamada taro")
        val savedAuthor1 = em.persistAndFlush(author1)

        val author2 = Author("tanaka ichiro")
        val savedAuthor2 = em.persistAndFlush(author2)

        val book = Book(
            title = "aws professional",
            published = LocalDate.of(2021, 11, 20)
        )
        em.persistAndFlush(book)
    }
}
