package com.kiyotakeshi.library.presentation.model

import io.swagger.annotations.ApiModelProperty

data class ReviewUserResponse(
    @ApiModelProperty(value = "ユーザID", example = "1")
    val id: Int?,

    @ApiModelProperty(value = "ユーザ名", example = "mike")
    val name: String,
)
