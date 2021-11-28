package com.kiyotakeshi.library.presentation.model

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import javax.validation.constraints.Size

@ApiModel(description = "リクエスト時に必要なレビューに関する情報")
data class ReviewRequest(

    @ApiModelProperty(value = "レビュータイトル", example = "Good for java beginner", required = true)
    @field:Size(min = 2, max = 100, message = "Invalid field: 2 ~ 100 character please")
    val title: String,

    @ApiModelProperty(value = "レビュー本文", example = "Good for java beginner", required = true)
    @field:Size(min = 1, max = 10000, message = "Invalid field: 2 ~ 100 character please")
    val description: String,

    // TODO: 入力値の制約の追加
    @ApiModelProperty(value = "星(1~5(0.5刻み) で表現できる)", example = "3.5", required = true)
    val rating: Double,

    @ApiModelProperty(value = "レビュー投稿者", example = "mike", required = true)
    val author: ReviewUserRequest,
)
