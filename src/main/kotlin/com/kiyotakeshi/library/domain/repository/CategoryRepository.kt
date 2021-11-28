package com.kiyotakeshi.library.domain.repository

import com.kiyotakeshi.library.domain.entity.Category
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CategoryRepository : JpaRepository<Category, Int> {
    fun findAllByNameIn(name: List<String>): List<Category>
}
