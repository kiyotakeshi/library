package com.kiyotakeshi.library.presentation.controller

import com.kiyotakeshi.library.domain.entity.Book
import com.kiyotakeshi.library.domain.entity.User
import com.kiyotakeshi.library.presentation.model.*
import com.kiyotakeshi.library.usecase.BookService
import com.kiyotakeshi.library.usecase.CategoryService
import com.kiyotakeshi.library.usecase.UserService
import io.swagger.annotations.*
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*

@Tag(name = "admin-controller", description = "**`ADMIN_ROLE` のユーザしか実施できない**")
@RestController
@RequestMapping(path = ["/admin"], produces = ["application/json"])
class AdminController(
    private val userService: UserService,
    private val categoryService: CategoryService,
    private val bookService: BookService
) {
    // -------------------------
    // /users
    // -------------------------
    @ApiOperation(
        "ユーザ一覧取得", notes = "DB にて保存されているユーザ一覧を表示。"
                + "\n ただしパスワードは `BCryptPasswordEncoder` によりハッシュ化している"
    )
    @ApiResponses(value = [ApiResponse(code = 200, message = "OK", response = User::class, responseContainer = "List")])
    @GetMapping("/users")
    fun getUsers(): List<User> = userService.getUsers()

    // TODO: 新規登録用の model にする
    // TODO: ResponseEntity を使用する
    // TODO: status code を適切なものを設定する
    @ApiOperation("ユーザの新規登録")
    @PostMapping("/users")
    fun registerUser(
        @ApiParam(value = "新規追加するユーザ", required = true) @RequestBody user: User
    ): User = userService.register(user)

    @ApiOperation("ユーザ一の削除")
    @DeleteMapping("/users/{userId}")
    fun deleteUser(@ApiParam(value = "ユーザID", required = true) @PathVariable userId: Int) = userService.delete(userId)

    // -------------------------
    // /categories
    // -------------------------
    @ApiOperation("カテゴリーの新規登録", notes = "登録済みのものを含む、カテゴリ名を複数指定してリクエスト可能。")
    @ApiResponses(
        value = [ApiResponse(
            code = 200,
            message = "新規登録されたカテゴリの一覧を返す",
            response = NewCategoryResponse::class,
            responseContainer = "List"
        )]
    )
    @PostMapping("/categories")
    fun registerCategory(
        @ApiParam(value = "新規追加するカテゴリー", required = true) @RequestBody category: List<NewCategoryRequest>
    ): List<NewCategoryResponse> = categoryService.registerCategory(category)

    // -------------------------
    // /books
    // -------------------------
    @ApiOperation("書籍の新規登録")
    @ApiResponses(value = [ApiResponse(code = 200, message = "OK", response = NewBookResponse::class)])
    @PostMapping("/books")
    fun registerBook(@RequestBody request: NewBookRequest): NewBookResponse = bookService.registerBook(request)

    // TODO: 新規更新用の request,response の model を使用する(新規登録と共通かも)
    @ApiOperation("書籍の更新")
    @PutMapping("/books/{bookId}")
    fun updateBook(
        @ApiParam(value = "書籍ID", required = true) @PathVariable("bookId") id: Int,
        // TODO: 更新用に model 分ける
        @ApiParam(value = "更新する書籍の情報", required = true) @RequestBody request: Book
    ): Book = bookService.updateBook(id, request)

    @ApiOperation("書籍の削除(関連するレビューも削除される)")
    @DeleteMapping("/books/{bookId}")
    fun deleteBook(@PathVariable("bookId") id: Int) = bookService.deleteBook(id)

    // TODO: レスポンスの model 見直す
    @ApiOperation("書籍にカテゴリーを登録(洗い替え)")
    @ApiResponses(value = [ApiResponse(code = 200, message = "リクエストのカテゴリで洗い替えた書籍の情報を返す", response = Book::class)])
    @PutMapping("/books/{bookId}/categories")
    fun registerBookCategories(
        @ApiParam(value = "カテゴリーを登録する書籍のID", required = true) @PathVariable bookId: Int,
        @ApiParam(value = "書籍に登録するカテゴリー", required = true) @RequestBody categories: List<BookCategoryRequest>
    ): Book = categoryService.registerBookCategories(bookId, categories)
}
