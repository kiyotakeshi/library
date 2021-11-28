package com.kiyotakeshi.library.presentation.model

import com.kiyotakeshi.library.domain.entity.Author
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import java.time.LocalDate

@ApiModel(description = "書籍の詳細情報")
data class BookDetailResponse(
    @ApiModelProperty(value = "書籍ID")
    val id: Int?,

    @ApiModelProperty(value = "タイトル", example = "hello java")
    val title: String,

    val author: List<BookAuthorResponse>?,

    @ApiModelProperty(value = "出版日", example = "2021-11-18")
    val published: LocalDate?,

    val categories: List<CategoryResponse>?,

    val reviews: List<ReviewResponse>?
)
