package com.kiyotakeshi.library.domain.entity

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonIgnore
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import javax.persistence.*
import javax.validation.constraints.Size

@Entity
@Table(name = "reviews")
@ApiModel(description = "レビュー")
data class Review(
    @ApiModelProperty(value = "レビュータイトル", example = "Good for java beginner", required = true)
    @field:Size(min = 2, max = 100, message = "Invalid field: 2 ~ 100 character please")
    val title: String,

    @ApiModelProperty(value = "レビュー本文", example = "Good for java beginner", required = true)
    @field:Size(min = 1, max = 10000, message = "Invalid field: 2 ~ 100 character please")
    val description: String,

    // TODO: 入力値の制約の追加
    @ApiModelProperty(value = "星(1~5(0.5刻み) で表現できる)", example = "3.5", required = true)
    val rating: Double,

    @ApiModelProperty(value = "レビュー投稿者", example = "mike", required = true)
    @ManyToOne
    val author: User,

    @ApiModelProperty(value = "レビュー対象の本", example = "", required = true)
    @ManyToOne
    @JsonIgnore
    val book: Book
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "DB で自動採番")
    val id: Int? = null
}
