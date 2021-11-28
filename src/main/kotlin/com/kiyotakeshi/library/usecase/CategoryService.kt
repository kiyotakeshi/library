package com.kiyotakeshi.library.usecase

import com.kiyotakeshi.library.domain.entity.Book
import com.kiyotakeshi.library.domain.entity.Category
import com.kiyotakeshi.library.presentation.model.BookCategoryRequest
import com.kiyotakeshi.library.presentation.model.CategoryResponse
import com.kiyotakeshi.library.presentation.model.NewCategoryRequest
import com.kiyotakeshi.library.presentation.model.NewCategoryResponse

interface CategoryService {
    fun getCategories(): List<CategoryResponse>
    fun registerCategory(categories: List<NewCategoryRequest>): List<NewCategoryResponse>
    fun registerBookCategories(bookId: Int, categories: List<BookCategoryRequest>): Book
}
