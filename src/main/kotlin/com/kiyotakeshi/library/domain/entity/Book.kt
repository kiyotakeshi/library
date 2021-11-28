package com.kiyotakeshi.library.domain.entity

import java.time.LocalDate
import javax.persistence.*
import javax.validation.constraints.Size

@Entity
@Table(name = "books")
data class Book(
    // @see https://kotlinlang.org/docs/annotations.html#annotation-use-site-targets
    @field:Size(min = 2, message = "Invalid field: too short")
    var title: String,

    @field:Size(min = 2, message = "Invalid field: too short")
    var author: String,

    var published: LocalDate?,
) {
    // id は DB で自動採番するためコンストラクタに含めない
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null

    @ManyToMany
    @JoinTable(
        name = "book_categories",
        joinColumns = [JoinColumn(name = "book_id")],
        inverseJoinColumns = [JoinColumn(name = "category_id")]
    )
    var categories: MutableList<Category>? = mutableListOf();

    fun deleteAllAndRegisterCategories(categories: List<Category>){
        this.categories?.clear()
        this.categories?.addAll(categories)
    }

    override fun toString(): String {
        return "Book(title='$title', author='$author', published=$published, id=$id, categories=$categories)"
    }
}


