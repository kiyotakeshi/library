package com.kiyotakeshi.library.usecase

import com.kiyotakeshi.library.domain.repository.AuthorRepository
import com.kiyotakeshi.library.presentation.model.BookAuthorResponse
import com.kiyotakeshi.library.presentation.model.BookSummaryResponse
import com.kiyotakeshi.library.presentation.model.CategoryResponse
import org.springframework.stereotype.Service

@Service
class AuthorServiceImpl(
    private val authorRepository: AuthorRepository
) : AuthorService {
    override fun getBooksByAuthor(authorId: Int): List<BookSummaryResponse> {
        val author = authorRepository.findById(authorId).orElseThrow()

        return author.books.map {
            BookSummaryResponse(
                it.id,
                it.title,
                it.authors?.map { author -> BookAuthorResponse(author.id, author.name) },
                it.published,
                it.categories?.map { category -> CategoryResponse(category.id, category.name) },
                it.calculateAverageRating()
            )
        }
    }
}
