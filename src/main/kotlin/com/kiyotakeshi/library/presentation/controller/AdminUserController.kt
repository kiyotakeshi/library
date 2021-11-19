package com.kiyotakeshi.library.presentation.controller

import com.kiyotakeshi.library.domain.User
import com.kiyotakeshi.library.usecase.UserService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/admin/users")
class AdminUserController(
    private val userService: UserService
) {
    @GetMapping
    fun getUsers(): List<User> = userService.getUsers()

    @PostMapping
    fun registerUser(@RequestBody user: User): User = userService.register(user)

    @DeleteMapping("/{userId}")
    fun deleteUser(@PathVariable userId: Int) = userService.delete(userId)
}