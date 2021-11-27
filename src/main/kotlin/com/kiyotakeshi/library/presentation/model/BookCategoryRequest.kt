package com.kiyotakeshi.library.presentation.model

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import javax.validation.constraints.Size

@ApiModel(description = "書籍に登録するカテゴリー")
data class BookCategoryRequest(

    @ApiModelProperty(value = "カテゴリID", example = "1", required = true)
    val id: Int,

    @ApiModelProperty(value = "カテゴリー名", example = "Java", required = true)
    @field:Size(min = 2, max = 100, message = "Invalid field: 2 ~ 100 character please")
    var name: String
)
