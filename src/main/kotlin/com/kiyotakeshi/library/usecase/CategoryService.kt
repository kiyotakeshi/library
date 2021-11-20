package com.kiyotakeshi.library.usecase

import com.kiyotakeshi.library.domain.Category

interface CategoryService {
    fun registerCategory(category: Category): Category
}
