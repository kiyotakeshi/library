package com.kiyotakeshi.library.security

import com.kiyotakeshi.library.domain.RoleType
import com.kiyotakeshi.library.domain.User
import com.kiyotakeshi.library.domain.UserRepository
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService

class LibraryUserDetailsService(
    private val userRepository: UserRepository
) : UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails? {
        val user: User? = userRepository.findByEmail(username)
        return user?.let { LibraryUserDetails(user) }
    }
}

// TODO: Keycloak を使用した OIDC に変える
data class LibraryUserDetails(val id: Int?, val email: String, val pass: String, val roleType: RoleType) :
    UserDetails {
    constructor(user: User) : this(user.id, user.email, user.password, user.roleType)

    override fun getAuthorities(): MutableCollection<out GrantedAuthority>? {
        return AuthorityUtils.createAuthorityList(this.roleType.toString())
    }

    override fun getPassword(): String {
        return this.pass
    }

    override fun getUsername(): String {
        return this.email
    }

    override fun isAccountNonExpired(): Boolean {
        return true;
    }

    override fun isAccountNonLocked(): Boolean {
        return true;
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true;
    }

    override fun isEnabled(): Boolean {
        return true;
    }
}
