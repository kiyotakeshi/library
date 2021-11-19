package com.kiyotakeshi.library.usecase

import com.kiyotakeshi.library.domain.User
import com.kiyotakeshi.library.domain.UserRepository
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
) : UserService {

    override fun getUserByEmail(email: String): User {
        return userRepository.findByEmail(email)
    }

    override fun register(request: User): User {
        val encodedPassword = passwordEncoder.encode(request.password)
        val user = User(request.email, encodedPassword, request.name, request.roleType)
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