package com.kiyotakeshi.library.usecase

import com.kiyotakeshi.library.domain.entity.Book
import com.kiyotakeshi.library.domain.repository.BookRepository
import com.kiyotakeshi.library.domain.entity.Category
import com.kiyotakeshi.library.domain.repository.CategoryRepository
import com.kiyotakeshi.library.presentation.model.BookCategoryRequest
import com.kiyotakeshi.library.presentation.model.CategoryResponse
import com.kiyotakeshi.library.presentation.model.NewCategoryRequest
import com.kiyotakeshi.library.presentation.model.NewCategoryResponse
import org.springframework.stereotype.Service

@Service
class CategoryServiceImpl(
    private val categoryRepository: CategoryRepository,
    private val bookRepository: BookRepository
) : CategoryService {

    override fun getCategories(): List<CategoryResponse> {
        return categoryRepository.findAll().map {
            CategoryResponse(it.id, it.name)
        }
    }

    override fun registerCategory(request: List<NewCategoryRequest>): List<NewCategoryResponse> {
        // @see https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/map.html
        val requestCategoryNames = request.map { it.name }.distinct() // ex.) Kotlin, Java, Test, JavaScript

        val foundCategoryNames =
            categoryRepository.findAllByNameIn(requestCategoryNames).map { it.name }  // ex.) Kotlin, Java

        // @see https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/filter-not.html
        val newCategoryNames =
            requestCategoryNames.filterNot { foundCategoryNames.contains(it) } // ex.) Test, JavaScript
        val newCategories = newCategoryNames.map { Category(it) }
        val savedCategories = categoryRepository.saveAll(newCategories)

        return savedCategories.map { NewCategoryResponse(it?.id, it.name) }
    }

    override fun registerBookCategories(bookId: Int, categories: List<BookCategoryRequest>): Book {
        val book = bookRepository.findById(bookId).orElseThrow()
        // リクエストのカテゴリが存在しているか確認
        val foundCategories = categoryRepository.findAllById(categories.map { it.id })
        book.deleteAllAndRegisterCategories(foundCategories)
        return bookRepository.save(book)
    }
}
