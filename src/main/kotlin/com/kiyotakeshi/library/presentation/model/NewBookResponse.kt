package com.kiyotakeshi.library.presentation.model

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import java.time.LocalDate

@ApiModel(description = "新規作成した本")
data class NewBookResponse(

    @ApiModelProperty(value = "DB で自動採番", example = "1")
    val id: Int?,

    @ApiModelProperty(value = "タイトル", example = "hello java")
    var title: String,

    @ApiModelProperty(value = "出版日", example = "2021-11-18")
    var published: LocalDate?
)
