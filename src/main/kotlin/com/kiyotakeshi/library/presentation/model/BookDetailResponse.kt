package com.kiyotakeshi.library.presentation.model

import com.kiyotakeshi.library.domain.entity.Category
import com.kiyotakeshi.library.domain.entity.Review
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import java.time.LocalDate

@ApiModel(description = "書籍の詳細情報")
data class BookDetailResponse(
    @ApiModelProperty(value = "書籍ID")
    val id: Int?,

    @ApiModelProperty(value = "タイトル", example = "hello java")
    val title: String,

    @ApiModelProperty(value = "筆者", example = "popcorn")
    val author: String,

    @ApiModelProperty(value = "出版日", example = "2021-11-18")
    val published: LocalDate?,

    @ApiModelProperty(value = "カテゴリ", example = "kotlin")
    val categories: List<Category>?,

    @ApiModelProperty(value = "レビュー")
    val reviews: List<ReviewResponse>?
)
