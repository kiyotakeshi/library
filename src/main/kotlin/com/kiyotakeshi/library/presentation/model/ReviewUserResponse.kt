package com.kiyotakeshi.library.presentation.model

import io.swagger.annotations.ApiModelProperty

data class ReviewUserResponse(
    @ApiModelProperty(value = "ユーザID")
    val id: Int?,

    @ApiModelProperty(value = "ユーザ名", example = "mike", required = true)
    val name: String,
)
