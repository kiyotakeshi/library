package com.kiyotakeshi.library.domain.entity

import com.kiyotakeshi.library.domain.RoleType
import org.junit.jupiter.api.Test
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.test.context.TestConstructor
import java.time.LocalDate

@DataJpaTest
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
internal class ReviewTest(
    private var em: TestEntityManager
) {
    @Test
    internal fun mapping() {
        val user = User("mike.popcorn@example.com", "1qazxsw2", "mike", RoleType.ROLE_USER)
        em.persistAndFlush(user)

        val author1 = Author("yamada taro")
        val savedAuthor1 = em.persistAndFlush(author1)

        val book = Book("aws professional", mutableListOf(savedAuthor1), LocalDate.of(2021, 11, 20))
        em.persistAndFlush(book)

        val review = Review(
            "awesome",
            "This books gives me beneficial information about production ready aws settings.",
            4.5,
            user,
            book
        )
        em.persistAndFlush(review)
    }
}
