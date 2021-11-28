package com.kiyotakeshi.library.presentation.model

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

@ApiModel(description = "カテゴリー情報(カテゴリに含まれる書籍情報は **カテゴリ別の書籍一覧の取得** で取得可能)")
data class CategoryResponse(

    @ApiModelProperty(value = "DB で自動採番", example = "1")
    val id: Int?,

    @ApiModelProperty(value = "カテゴリー名", example = "Java")
    val name: String
)
