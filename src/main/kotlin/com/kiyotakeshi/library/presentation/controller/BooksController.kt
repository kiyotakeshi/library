package com.kiyotakeshi.library.presentation.controller

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

    @GetMapping("/{bookId}")
    fun getBook(@PathVariable("bookId") id: Int): Book {
        return bookService.getBook(id)
    }

    @PutMapping("/{bookId}")
    fun updateBook(@PathVariable("bookId") id: Int, @RequestBody request: Book): Book {
        return bookService.updateBook(id,request)
    }

    @DeleteMapping("/{bookId}")
    fun deleteBook(@PathVariable("bookId") id: Int) {
        return bookService.deleteBook(id)
    }
}