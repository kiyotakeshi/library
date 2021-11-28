package com.kiyotakeshi.library.presentation.model

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import javax.validation.constraints.Email

@ApiModel(description = "レビュー投稿時のユーザ情報")
data class ReviewUserRequest(

    @ApiModelProperty(value = "DB で自動採番", example = "1")
    val id: Int?,

    @ApiModelProperty(value = "ログイン時にパスワードと共に使用される", example = "test@example.com", required = true)
    @field:Email
    val email: String,

    @ApiModelProperty(value = "ユーザ名", example = "mike", required = true)
    val name: String
)
