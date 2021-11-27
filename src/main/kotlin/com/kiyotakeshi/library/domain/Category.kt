package com.kiyotakeshi.library.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import javax.persistence.*
import javax.validation.constraints.Size

@Entity
@Table(name = "categories")
@ApiModel(description = "書籍のカテゴリー情報")
data class Category(
    @ApiModelProperty(value = "カテゴリー名", example = "Java", required = true)
    @field:Size(min = 2, max = 100, message = "Invalid field: 2 ~ 100 character please")
    var name: String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "DB で自動採番")
    val id: Int? = null

    @ManyToMany(mappedBy = "categories")
    @JsonIgnore
    var books: MutableList<Book> = mutableListOf();
}
