package com.kiyotakeshi.library.domain.entity

import com.fasterxml.jackson.annotation.JsonManagedReference
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import java.time.LocalDate
import javax.persistence.*
import javax.validation.constraints.Size

@Entity
@Table(name = "books")
@ApiModel(description = "本")
data class Book(

    @ApiModelProperty(value = "タイトル", example = "hello java", required = true)
    // @see https://kotlinlang.org/docs/annotations.html#annotation-use-site-targets
    @field:Size(min = 2, message = "Invalid field: too short")
    var title: String,

    @ApiModelProperty(value = "筆者", example = "popcorn", required = true)
    @field:Size(min = 2, message = "Invalid field: too short")
    var author: String,

    @ApiModelProperty(value = "出版日", example = "2021-11-18", required = false)
    var published: LocalDate?,
) {
    // id は DB で自動採番するためコンストラクタに含めない
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "DB で自動採番")
    val id: Int? = null

    @ManyToMany
    @JoinTable(
        name = "book_categories",
        joinColumns = [JoinColumn(name = "book_id")],
        inverseJoinColumns = [JoinColumn(name = "category_id")]
    )
    var categories: MutableList<Category>? = mutableListOf()

    // book を削除する場合は紐づく review から先に削除する
    // (review table の外部キー制約も指定がある) orphanRemoval を指定
    @OneToMany(mappedBy = "book", fetch = FetchType.EAGER, cascade = [CascadeType.PERSIST], orphanRemoval = true)
    @JsonManagedReference
    var reviews: MutableList<Review> = mutableListOf()

    fun deleteAllAndRegisterCategories(categories: List<Category>) {
        this.categories?.clear()
        this.categories?.addAll(categories)
    }

    fun calculateAverageRating(): Double {
        return this.reviews.map { it.rating }.average()
    }

    fun deleteReview(review: Review) {
        this.reviews.remove(review)
    }

    override fun toString(): String {
        return "Book(title='$title', author='$author', published=$published, id=$id, categories=$categories, reviews=$reviews)"
    }
}


