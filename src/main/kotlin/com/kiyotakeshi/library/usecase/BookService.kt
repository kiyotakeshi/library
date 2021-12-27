package com.kiyotakeshi.library.usecase

import com.kiyotakeshi.library.domain.entity.Book
import com.kiyotakeshi.library.presentation.model.*

interface BookService {

    fun getBooks(): List<BookSummaryResponse>

    fun getBooksByCategory(categoryId: Int): List<Book>

    fun getBook(id: Int): BookDetailResponse

    fun registerBook(request: NewBookRequest): NewBookResponse

    fun updateBook(id: Int, request: BookUpdateRequest): Book

    fun deleteBook(id: Int)

    fun postReview(id: Int, request: ReviewRequest): ReviewResponse
}
