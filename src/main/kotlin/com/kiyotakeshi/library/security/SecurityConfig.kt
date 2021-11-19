package com.kiyotakeshi.library.security

import com.kiyotakeshi.library.domain.RoleType.*
import com.kiyotakeshi.library.domain.UserRepository
import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder




@EnableWebSecurity
class SecurityConfig(
    private val userRepository: UserRepository
) : WebSecurityConfigurerAdapter() {

    @Bean
    fun passwordEncoder(): PasswordEncoder? {
        return BCryptPasswordEncoder()
    }

    override fun configure(http: HttpSecurity) {
        http.authorizeRequests().antMatchers(
            "/login",
            "/swagger-ui/**",
            "/v3/api-docs",
            "/swagger-resources/**",
        ).permitAll()

        http.authorizeRequests()
            .antMatchers("/books/**").hasAnyAuthority(ROLE_USER.toString(), ROLE_ADMIN.toString())
            .antMatchers("/admin/**").hasAuthority(ROLE_ADMIN.toString())
            .anyRequest().authenticated()

        http.csrf().disable()
            .formLogin()
            .loginProcessingUrl("/login")
            .usernameParameter("email")
            .passwordParameter("pass")
            .successHandler(LibraryAuthenticationSuccessHandler())
            .failureHandler(LibraryAuthenticationFailureHandler())

        http.exceptionHandling().authenticationEntryPoint(LibraryAuthenticationEntryPoint())
    }

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.userDetailsService(LibraryUserDetailsService(userRepository))
            .passwordEncoder(BCryptPasswordEncoder())
    }

}