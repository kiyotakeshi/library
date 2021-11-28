package com.kiyotakeshi.library.domain.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import javax.persistence.*
import javax.validation.constraints.Size

@Entity
@Table(name = "authors")
@ApiModel(description = "筆者")
data class Author(

    @ApiModelProperty(value = "名前", example = "yamada taro", required = true)
    @field:Size(min = 2, max = 100, message = "Invalid field: too short")
    val name: String,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "DB で自動採番")
    val id: Int? = null

    @ManyToMany(mappedBy = "authors")
    // @JsonIgnore
    var books: MutableList<Book> = mutableListOf()
}
