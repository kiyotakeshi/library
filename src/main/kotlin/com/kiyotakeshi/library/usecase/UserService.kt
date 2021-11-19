package com.kiyotakeshi.library.usecase

import com.kiyotakeshi.library.domain.User

interface UserService {
    fun getUserByEmail(email: String): User
    fun register(user: User): User
    fun delete(userId: Int)
    fun getUsers(): List<User>
}
