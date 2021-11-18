package com.kiyotakeshi.library.domain

import org.hibernate.Hibernate
import org.jetbrains.annotations.NotNull
import java.time.LocalDate
import javax.persistence.*
import javax.validation.constraints.Size

@Entity
@Table(name = "books")
class Book(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,

    // @see https://kotlinlang.org/docs/annotations.html#annotation-use-site-targets
    @field:Size(min = 2, message = "Invalid field: too short")
    var title: String,

    @field:Size(min = 2, message = "Invalid field: too short")
    var author: String,

    var published: LocalDate?

) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Book

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    override fun toString(): String {
        return this::class.simpleName + "(id = $id , title = $title , author = $author , published = $published )"
    }
}


