package com.kiyotakeshi.library.domain.repository

import com.kiyotakeshi.library.domain.entity.Author
import org.springframework.data.jpa.repository.JpaRepository

interface AuthorRepository: JpaRepository<Author, Int>
