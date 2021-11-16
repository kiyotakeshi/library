package com.kiyotakeshi.library.controller

import com.kiyotakeshi.library.domain.Book
import com.kiyotakeshi.library.usecase.BookService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("books")
class BooksController(
    private val bookService: BookService
) {
    @GetMapping
    fun getBooks(): List<Book> {
        return bookService.getBooks()
    }

    @PostMapping
    fun registerBook(@RequestBody request: Book): Book {
        return bookService.registerBook(request)
    }
}