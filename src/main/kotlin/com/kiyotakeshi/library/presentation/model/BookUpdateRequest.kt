package com.kiyotakeshi.library.presentation.model

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import java.time.LocalDate
import javax.validation.constraints.Size

@ApiModel(description = "更新作成する本")
data class BookUpdateRequest(

    @ApiModelProperty(value = "タイトル", example = "JVM performance", required = true)
    @field:Size(min = 2, message = "Invalid field: too short")
    val title: String,

    val authors: List<BookAuthorRequest>?,

    // https://swagger.io/docs/specification/data-models/data-types/#format date で認識できないみたい
    @ApiModelProperty(value = "出版日", example = "2021-11-18", required = false, dataType = "date")
    var published: LocalDate?,

    val categories: List<CategoryRequest>?
)
