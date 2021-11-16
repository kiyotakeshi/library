package com.kiyotakeshi.library.usecase

import com.kiyotakeshi.library.domain.Book
import com.kiyotakeshi.library.domain.BookRepository
import org.springframework.stereotype.Service

@Service
class BookService(
    private val bookRepository: BookRepository
) {
    fun getBooks(): List<Book> {
        return bookRepository.findAll()
    }

    fun registerBook(book: Book): Book {
        return bookRepository.save(book)
    }
}