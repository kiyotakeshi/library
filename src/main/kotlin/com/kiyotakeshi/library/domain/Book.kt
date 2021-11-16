package com.kiyotakeshi.library.domain

import org.jetbrains.annotations.NotNull
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "books")
data class Book (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int = 0,

    @NotNull
    var title: String = "",

    @NotNull
    var author: String = "",

    var published: LocalDate? = null
)



