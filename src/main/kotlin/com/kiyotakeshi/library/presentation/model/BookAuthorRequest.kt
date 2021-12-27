package com.kiyotakeshi.library.presentation.model

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

@ApiModel(description = "書籍のプロパティに含まれる筆者の情報")
data class BookAuthorRequest(
    @ApiModelProperty(value = "名前", example = "yamada taro")
    val name: String
)
