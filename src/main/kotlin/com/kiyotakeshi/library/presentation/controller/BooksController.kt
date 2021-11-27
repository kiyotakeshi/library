package com.kiyotakeshi.library.presentation.controller

import com.kiyotakeshi.library.domain.Book
import com.kiyotakeshi.library.domain.User
import com.kiyotakeshi.library.usecase.BookService
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = ["books"], produces = ["application/json"])
class BooksController(
    private val bookService: BookService
) {

    @ApiResponses(value = [ApiResponse(code = 200, message = "OK", response = Book::class, responseContainer = "List")])
    @ApiOperation("書籍一覧の取得")
    @GetMapping
    fun getBooks(): List<Book> = bookService.getBooks()

    @ApiOperation("書籍の取得")
    @GetMapping("/{bookId}")
    fun getBook(@PathVariable("bookId") id: Int): Book = bookService.getBook(id)


}
