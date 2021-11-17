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

    fun getBook(id: Int): Book {
        return bookRepository.findById(id).orElseThrow()
    }

    fun updateBook(id: Int, request: Book): Book {
        val book = bookRepository.findById(id).orElseThrow()
        book.author = request.author
        book.title = request.title
        book.published = request.published
        return bookRepository.save(book)
    }

    fun deleteBook(id: Int) {
        return bookRepository.deleteById(id)
    }
}