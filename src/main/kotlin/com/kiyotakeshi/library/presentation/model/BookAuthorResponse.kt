package com.kiyotakeshi.library.presentation.model

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

@ApiModel(description = "書籍のプロパティに含まれる筆者の情報")
data class BookAuthorResponse(

    @ApiModelProperty(value = "DB で自動採番", example = "1")
    val id: Int?,

    @ApiModelProperty(value = "名前", example = "yamada taro")
    val name: String
)
