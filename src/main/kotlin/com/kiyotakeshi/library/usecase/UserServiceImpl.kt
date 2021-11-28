package com.kiyotakeshi.library.usecase

import com.kiyotakeshi.library.domain.entity.User
import com.kiyotakeshi.library.domain.repository.UserRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
) : UserService {

    override fun getUserByEmail(email: String): User {
        return userRepository.findByEmail(email).orElseThrow()
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
