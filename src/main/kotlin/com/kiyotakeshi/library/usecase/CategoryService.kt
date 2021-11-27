package com.kiyotakeshi.library.usecase

import com.kiyotakeshi.library.domain.Book
import com.kiyotakeshi.library.domain.Category
import com.kiyotakeshi.library.presentation.model.BookCategoryRequest
import com.kiyotakeshi.library.presentation.model.NewCategoryRequest
import com.kiyotakeshi.library.presentation.model.NewCategoryResponse

interface CategoryService {
    fun getCategories(): List<Category>
    fun registerBookCategories(bookId: Int, categories: List<BookCategoryRequest>): Book
}
