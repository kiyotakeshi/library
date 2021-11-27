package com.kiyotakeshi.library.presentation.controller

import com.kiyotakeshi.library.domain.Book
import com.kiyotakeshi.library.domain.Category
import com.kiyotakeshi.library.usecase.CategoryService
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["categories"], produces = ["application/json"])
class CategoryController(
    private val categoryService: CategoryService
) {

    @ApiOperation("カテゴリ一覧の取得")
    @ApiResponses(value = [ApiResponse(code = 200, message = "OK", response = Category::class, responseContainer = "List")])
    @GetMapping
    fun getCategories(): List<Category> = categoryService.getCategories()
}
