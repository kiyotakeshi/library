package com.kiyotakeshi.library.presentation.model

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import javax.validation.constraints.Size

@ApiModel(description = "筆者の新規作成リクエスト")
data class NewAuthorRequest(
    @ApiModelProperty(value = "名前", example = "yamada taro", required = true)
    @field:Size(min = 2, max = 100, message = "Invalid field: too short")
    val name: String,
)
