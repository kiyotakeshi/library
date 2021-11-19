package com.kiyotakeshi.library.domain

import javax.persistence.*
import javax.validation.constraints.Email
import javax.validation.constraints.Size

@Entity
@Table(name = "users")
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,
    @field:Email
    val email: String,
    @field:Size(min = 6, message = "Password is too short")
    val password: String,
    val name: String,

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    val roleType: RoleType
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as User

        if (id != other.id) return false
        if (email != other.email) return false
        if (password != other.password) return false
        if (name != other.name) return false
        if (roleType != other.roleType) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id ?: 0
        result = 31 * result + email.hashCode()
        result = 31 * result + password.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + roleType.hashCode()
        return result
    }

    override fun toString(): String {
        return "User(id=$id, email='$email', password='$password', name='$name', roleType=$roleType)"
    }
}