package com.kiyotakeshi.library.presentation.controller

import com.kiyotakeshi.library.domain.Book
import com.kiyotakeshi.library.domain.User
import com.kiyotakeshi.library.usecase.BookService
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = ["books"], produces = ["application/json"])
class BooksController(
    private val bookService: BookService
) {
    // TODO: レビューの星情報はレスポンスに含める
    @ApiOperation("書籍一覧の取得")
    @ApiResponses(value = [ApiResponse(code = 200, message = "OK", response = Book::class, responseContainer = "List")])
    @GetMapping
    fun getBooks(): List<Book> = bookService.getBooks()

    @ApiOperation("カテゴリ別の書籍一覧の取得")
    @ApiResponses(value = [ApiResponse(code = 200, message = "OK", response = Book::class, responseContainer = "List")])
    @GetMapping("/categories/{categoryId}")
    fun getBooksByCategory(
        @ApiParam(value = "閲覧したいカテゴリーのID", required = true) @PathVariable categoryId: Int
    ): List<Book> = bookService.getBooksByCategory(categoryId)

    // TODO: レビュー内容はこちらのリクエストで返す
    @ApiOperation("書籍の取得")
    @ApiResponses(value = [ApiResponse(code = 200, message = "OK", response = Book::class)])
    @GetMapping("/{bookId}")
    fun getBook(
        @ApiParam(value = "書籍ID", required = true) @PathVariable("bookId") id: Int
    ): Book = bookService.getBook(id)
}
