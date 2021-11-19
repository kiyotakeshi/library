package com.kiyotakeshi.library.presentation.controller

import com.kiyotakeshi.library.domain.User
import com.kiyotakeshi.library.usecase.UserService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserController(
    private val userService: UserService
) {
    // admin しかできない処理にする
    @GetMapping
    fun getUsers(): List<User> = userService.getUsers()

    // TODO: ユーザのマイページに使う？ `/{email}` は変える
    // TODO: Spring Security で自身のものしか見れないように制御する
    @GetMapping("/{email}")
    fun getUser(@PathVariable email: String): User {
        return userService.getUserByEmail(email)
    }

    // TODO: プロフィール編集などできるようにするのであれば
    // @PutMapping

    // admin しかできない処理にする
    @PostMapping
    fun registerUser(@RequestBody user: User): User = userService.register(user)

    // admin しかできない処理にする
    @DeleteMapping("/{userId}")
    fun deleteUser(@PathVariable userId: Int) = userService.delete(userId)
}