package com.kiyotakeshi.library.presentation.controller

import com.kiyotakeshi.library.domain.Category
import com.kiyotakeshi.library.domain.User
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
    private val categoryService: CategoryService
) {
    @ApiOperation(
        "ユーザ一覧取得", notes = "DB にて保存されているユーザ一覧を表示。"
                + "\n ただしパスワードは `BCryptPasswordEncoder` によりハッシュ化している"
    )
    @ApiResponses(value = [ApiResponse(code = 200, message = "OK", response = User::class, responseContainer = "List")])
    @GetMapping("/users")
    fun getUsers(): List<User> = userService.getUsers()

    @ApiOperation("ユーザの新規登録")
    @PostMapping("/users")
    fun registerUser(
        @ApiParam(value = "新規追加するユーザ", required = true)
        @RequestBody user: User
    ): User =
        userService.register(user)

    @ApiOperation("ユーザ一の削除")
    @DeleteMapping("/users/{userId}")
    fun deleteUser(@PathVariable userId: Int) = userService.delete(userId)

    @ApiOperation("カテゴリーの新規登録")
    @PostMapping("/categories")
    fun registerCategory(
        @ApiParam(value = "新規追加するカテゴリー", required = true)
        @RequestBody category: Category
    ): Category = categoryService.registerCategory(category)
}
