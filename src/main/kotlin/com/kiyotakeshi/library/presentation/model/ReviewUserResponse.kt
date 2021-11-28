package com.kiyotakeshi.library.presentation.model

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

@ApiModel(description = "レビュー投稿者")
data class ReviewUserResponse(
    @ApiModelProperty(value = "ユーザID", example = "1")
    val id: Int?,

    @ApiModelProperty(value = "ユーザ名", example = "mike")
    val name: String,
)
