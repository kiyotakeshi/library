package com.kiyotakeshi.library.usecase

import com.kiyotakeshi.library.domain.entity.Book
import com.kiyotakeshi.library.presentation.model.BookDetailResponse
import com.kiyotakeshi.library.presentation.model.BookSummaryResponse
import com.kiyotakeshi.library.presentation.model.ReviewRequest
import com.kiyotakeshi.library.presentation.model.ReviewResponse

interface BookService {

    fun getBooks(): List<BookSummaryResponse>

    fun getBooksByCategory(categoryId: Int): List<Book>

    fun getBook(id: Int): BookDetailResponse

    fun registerBook(book: Book): Book

    fun updateBook(id: Int, request: Book): Book

    fun deleteBook(id: Int)

    fun postReview(id: Int, request: ReviewRequest): ReviewResponse
}
