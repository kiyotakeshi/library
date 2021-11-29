package com.kiyotakeshi.library.presentation.controller

import com.kiyotakeshi.library.presentation.model.AuthorResponse
import com.kiyotakeshi.library.presentation.model.BookSummaryResponse
import com.kiyotakeshi.library.usecase.AuthorService
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["/authors"], produces = ["application/json"])
class AuthorController(
    private val authorService: AuthorService
) {
    @ApiOperation("筆者一覧の取得")
    @ApiResponses(
        value = [
            ApiResponse(code = 200, message = "OK", response = AuthorResponse::class, responseContainer = "List")
        ]
    )
    @GetMapping
    fun getAuthors(): List<AuthorResponse> = authorService.getAuthors()

    @ApiOperation("筆者別の書籍一覧の取得")
    @ApiResponses(
        value = [
            ApiResponse(code = 200, message = "OK", response = BookSummaryResponse::class, responseContainer = "List")
        ]
    )
    @GetMapping("/{authorId}/books")
    fun getBooksByAuthor(
        @ApiParam(value = "閲覧したい筆者のID", required = true, example = "1") @PathVariable authorId: Int
    ): List<BookSummaryResponse> = authorService.getBooksByAuthor(authorId)
}
