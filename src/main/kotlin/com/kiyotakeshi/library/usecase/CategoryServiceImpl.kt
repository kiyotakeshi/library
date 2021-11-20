package com.kiyotakeshi.library.usecase

import com.kiyotakeshi.library.domain.Category
import com.kiyotakeshi.library.domain.CategoryRepository
import org.springframework.stereotype.Service

@Service
class CategoryServiceImpl(
    private val categoryRepository: CategoryRepository
) : CategoryService {
    override fun registerCategory(category: Category): Category {
        return categoryRepository.save(category)
    }
}
