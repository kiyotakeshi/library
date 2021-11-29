package com.kiyotakeshi.library.presentation.model

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

@ApiModel(description = "筆者のレスポンス")
data class AuthorResponse(
    @ApiModelProperty(value = "DB で自動採番")
    val id: Int?,

    @ApiModelProperty(value = "名前", example = "yamada taro")
    val name: String
)
