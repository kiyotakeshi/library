package com.kiyotakeshi.library.usecase

import com.kiyotakeshi.library.domain.Book
import com.kiyotakeshi.library.domain.BookRepository
import org.springframework.stereotype.Service

//
// https://stackoverflow.com/a/28693263
@Service
class BookServiceImpl(
    private val bookRepository: BookRepository
) : BookService {

    override fun getBooks(): List<Book> = bookRepository.findAll()

    override fun registerBook(book: Book): Book = bookRepository.save(book)

    override fun getBook(id: Int): Book = bookRepository.findById(id).orElseThrow()

    override fun updateBook(id: Int, request: Book): Book {
        val book = bookRepository.findById(id).orElseThrow()
        book.author = request.author
        book.title = request.title
        book.published = request.published
        return bookRepository.save(book)
    }

    override fun deleteBook(id: Int) = bookRepository.deleteById(id)
}