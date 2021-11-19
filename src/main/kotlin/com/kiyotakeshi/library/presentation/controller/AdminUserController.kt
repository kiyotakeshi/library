package com.kiyotakeshi.library.presentation.controller

import com.kiyotakeshi.library.domain.User
import com.kiyotakeshi.library.usecase.UserService
import io.swagger.annotations.*
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*

@Tag(name = "admin-user-controller", description = "**`ADMIN_ROLE` のユーザしか実施できない**")
@RestController
@RequestMapping("/admin/users")
class AdminUserController(
    private val userService: UserService
) {
    @ApiOperation(
        "ユーザ一覧取得", notes = "DB にて保存されているユーザ一覧を表示。"
                + "\n ただしパスワードは `BCryptPasswordEncoder` によりハッシュ化している"
    )
    @ApiResponse(code = 200, message = "OK", response = User::class)
    @GetMapping
    fun getUsers(): List<User> = userService.getUsers()

    @ApiOperation("ユーザの新規登録")
    @PostMapping
    fun registerUser(@ApiParam(value = "新規追加するユーザ", required = true) @RequestBody user: User): User =
        userService.register(user)

    @ApiOperation("ユーザ一の削除")
    @DeleteMapping("/{userId}")
    fun deleteUser(@PathVariable userId: Int) = userService.delete(userId)
}