package com.kiyotakeshi.library.domain.repository

import com.kiyotakeshi.library.domain.entity.Review
import org.springframework.data.jpa.repository.JpaRepository

interface ReviewRepository: JpaRepository<Review, Int>
