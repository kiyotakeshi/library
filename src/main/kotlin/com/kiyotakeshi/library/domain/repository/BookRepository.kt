package com.kiyotakeshi.library.domain.repository

import com.kiyotakeshi.library.domain.entity.Book
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BookRepository : JpaRepository<Book,Int>
