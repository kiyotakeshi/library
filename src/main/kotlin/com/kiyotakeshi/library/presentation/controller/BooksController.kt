package com.kiyotakeshi.library.presentation.controller

import com.kiyotakeshi.library.domain.entity.Book
import com.kiyotakeshi.library.presentation.model.BookDetailResponse
import com.kiyotakeshi.library.presentation.model.BookSummaryResponse
import com.kiyotakeshi.library.usecase.BookService
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = ["books"], produces = ["application/json"])
class BooksController(
    private val bookService: BookService
) {
    @ApiOperation("書籍一覧の取得")
    @ApiResponses(value = [ApiResponse(code = 200, message = "OK", response = Book::class, responseContainer = "List")])
    @GetMapping
    fun getBooks(): List<BookSummaryResponse> = bookService.getBooks()

    // TODO: BookSummaryResponse を返すよう修正
    @ApiOperation("カテゴリ別の書籍一覧の取得")
    @ApiResponses(value = [ApiResponse(code = 200, message = "OK", response = Book::class, responseContainer = "List")])
    @GetMapping("/categories/{categoryId}")
    fun getBooksByCategory(
        @ApiParam(value = "閲覧したいカテゴリーのID", required = true, example = "1") @PathVariable categoryId: Int
    ): List<Book> = bookService.getBooksByCategory(categoryId)

    @ApiOperation("書籍詳細の取得")
    @ApiResponses(value = [ApiResponse(code = 200, message = "OK", response = Book::class)])
    @GetMapping("/{bookId}")
    fun getBook(
        @ApiParam(value = "書籍ID", required = true, example = "1") @PathVariable("bookId") id: Int
    ): BookDetailResponse = bookService.getBook(id)
}
