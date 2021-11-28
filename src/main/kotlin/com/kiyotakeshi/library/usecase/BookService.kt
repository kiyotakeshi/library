package com.kiyotakeshi.library.usecase

import com.kiyotakeshi.library.domain.entity.Book
import com.kiyotakeshi.library.presentation.model.BookSummaryResponse

interface BookService {

    fun getBooks(): List<BookSummaryResponse>

    fun getBooksByCategory(categoryId: Int): List<Book>

    fun getBook(id: Int): Book

    fun registerBook(book: Book): Book

    fun updateBook(id: Int, request: Book): Book

    fun deleteBook(id: Int)
}
