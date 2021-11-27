package com.kiyotakeshi.library.presentation.model

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

@ApiModel(description = "新規作成されたカテゴリー情報")
data class NewCategoryResponse(
    @ApiModelProperty(value = "DB で自動採番されたカテゴリーID", example = "100")
    val id: Int?,

    @ApiModelProperty(value = "カテゴリー名", example = "AWS")
    val name: String
)
