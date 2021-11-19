package com.kiyotakeshi.library.usecase

import com.kiyotakeshi.library.domain.User
import com.kiyotakeshi.library.domain.UserRepository
import org.springframework.stereotype.Service

@Service
class UserServiceImpl (
    private val userRepository: UserRepository
) : UserService {

    override fun getUserByEmail(email: String): User {
        return userRepository.findByEmail(email)
    }

    override fun register(user: User): User {
        return userRepository.save(user)
    }

    override fun delete(userId: Int) {
        val user = userRepository.findById(userId).orElseThrow()
        return userRepository.delete(user)
    }

    override fun getUsers(): List<User> {
        return userRepository.findAll()
    }
}