package com.kiyotakeshi.library.usecase

import com.kiyotakeshi.library.domain.Book
import com.kiyotakeshi.library.domain.BookRepository
import com.kiyotakeshi.library.domain.Category
import com.kiyotakeshi.library.domain.CategoryRepository
import com.kiyotakeshi.library.presentation.model.BookCategoryRequest
import com.kiyotakeshi.library.presentation.model.NewCategoryRequest
import com.kiyotakeshi.library.presentation.model.NewCategoryResponse
import org.springframework.stereotype.Service

@Service
class CategoryServiceImpl(
    private val categoryRepository: CategoryRepository,
    private val bookRepository: BookRepository
) : CategoryService {

    override fun getCategories(): List<Category> {
        return categoryRepository.findAll()
    }


    override fun registerBookCategories(bookId: Int, categories: List<BookCategoryRequest>): Book {
        val book = bookRepository.findById(bookId).orElseThrow()
        // リクエストのカテゴリが存在しているか確認
        val foundCategories = categoryRepository.findAllById(categories.map { it.id })
        book.deleteAllAndRegisterCategories(foundCategories)
        return bookRepository.save(book)
    }
}
