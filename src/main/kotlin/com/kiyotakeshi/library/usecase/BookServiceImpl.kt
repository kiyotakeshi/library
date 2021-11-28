package com.kiyotakeshi.library.usecase

import com.kiyotakeshi.library.domain.entity.Book
import com.kiyotakeshi.library.domain.entity.Review
import com.kiyotakeshi.library.domain.repository.BookRepository
import com.kiyotakeshi.library.domain.repository.CategoryRepository
import com.kiyotakeshi.library.domain.repository.ReviewRepository
import com.kiyotakeshi.library.domain.repository.UserRepository
import com.kiyotakeshi.library.presentation.model.*
import org.springframework.stereotype.Service

@Service
class BookServiceImpl(
    private val bookRepository: BookRepository,
    private val categoryRepository: CategoryRepository,
    private val reviewRepository: ReviewRepository,
    private val userRepository: UserRepository
) : BookService {

    override fun getBooks(): List<BookSummaryResponse> {
        val foundBooks: MutableList<Book> = bookRepository.findAll()

        return foundBooks.map {
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

    override fun getBooksByCategory(categoryId: Int): List<Book> {
        return categoryRepository.findById(categoryId).orElseThrow().books
    }

    override fun getBook(id: Int): BookDetailResponse {
        val book = bookRepository.findById(id).orElseThrow()
        val reviews = book.reviews.map {
            ReviewResponse(
                it.id,
                it.title,
                it.description,
                it.rating,
                ReviewUserResponse(it.author.id, it.author.name)
            )
        }
        return BookDetailResponse(
            book.id,
            book.title,
            book.authors?.map { BookAuthorResponse(it.id, it.name) },
            book.published,
            book.categories?.map { CategoryResponse(it.id, it.name) },
            reviews
        )
    }

    override fun registerBook(book: Book): Book = bookRepository.save(book)

    override fun updateBook(id: Int, request: Book): Book {
        val book = bookRepository.findById(id).orElseThrow()
        book.authors = request.authors
        book.title = request.title
        book.published = request.published
        return bookRepository.save(book)
    }

    override fun deleteBook(id: Int) = bookRepository.deleteById(id)

    override fun postReview(id: Int, request: ReviewRequest): ReviewResponse {
        val book: Book = bookRepository.findById(id).orElseThrow()
        val user = userRepository.findByEmail(request.author.email).orElseThrow()

        val newReview = Review(
            request.title,
            request.description,
            request.rating,
            user,
            book
        )
        val savedReview = reviewRepository.save(newReview)

        return ReviewResponse(
            savedReview.id,
            savedReview.title,
            savedReview.description,
            savedReview.rating,
            ReviewUserResponse(savedReview.author.id, savedReview.author.name)
        )
    }
}
