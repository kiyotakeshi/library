package com.kiyotakeshi.library.usecase

import com.kiyotakeshi.library.domain.Book
import com.kiyotakeshi.library.domain.BookRepository

interface BookService {

    fun getBooks(): List<Book>

    fun getBooksByCategory(categoryId: Int): List<Book>

    fun getBook(id: Int): Book

    fun registerBook(book: Book): Book

    fun updateBook(id: Int, request: Book): Book

    fun deleteBook(id: Int)
}
