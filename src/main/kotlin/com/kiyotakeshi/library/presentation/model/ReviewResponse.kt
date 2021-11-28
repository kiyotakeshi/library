package com.kiyotakeshi.library.presentation.model

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

@ApiModel(description = "レビューのレスポンス")
data class ReviewResponse(
    @ApiModelProperty(value = "レビューID")
    val id: Int?,

    @ApiModelProperty(value = "レビュータイトル", example = "Good for java beginner", required = true)
    val title: String,

    @ApiModelProperty(value = "レビュー本文", example = "Good for java beginner", required = true)
    val description: String,

    @ApiModelProperty(value = "星(1~5(0.5刻み) で表現できる)", example = "3.5", required = true)
    val rating: Double,

    @ApiModelProperty(value = "レビュー投稿者", required = true)
    val author: ReviewUserResponse
)
