package com.kiyotakeshi.library.presentation.model

import com.fasterxml.jackson.annotation.JsonManagedReference
import com.kiyotakeshi.library.domain.entity.Author
import com.kiyotakeshi.library.domain.entity.Category
import com.kiyotakeshi.library.domain.entity.Review
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import java.time.LocalDate
import javax.persistence.*
import javax.validation.constraints.Size

@ApiModel(description = "書籍一覧で返す書籍情報")
data class BookSummaryResponse(
    @ApiModelProperty(value = "書籍ID")
    val id: Int?,

    @ApiModelProperty(value = "タイトル", example = "hello java")
    val title: String,

    @ApiModelProperty(value = "筆者", example = "popcorn")
    val author: List<Author>?,

    @ApiModelProperty(value = "出版日", example = "2021-11-18")
    val published: LocalDate?,

    @ApiModelProperty(value = "カテゴリ")
    val categories: List<CategoryResponse>?,

    // TODO: レビューの件数を追加

    @ApiModelProperty(value = "レビューの星(rating)の平均", example = "3.5")
    val star: Double?
)
