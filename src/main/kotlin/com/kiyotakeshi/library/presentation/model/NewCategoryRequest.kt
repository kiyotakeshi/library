package com.kiyotakeshi.library.presentation.model

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import javax.validation.constraints.Size

@ApiModel(description = "新規登録するカテゴリー")
data class NewCategoryRequest(
    @ApiModelProperty(value = "カテゴリー名", example = "AWS", required = true)
    @field:Size(min = 2, max = 100, message = "Invalid field: 2 ~ 100 character please")
    var name: String
)
