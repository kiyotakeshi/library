package com.kiyotakeshi.library.usecase

import com.kiyotakeshi.library.domain.entity.Book
import com.kiyotakeshi.library.domain.repository.BookRepository
import com.kiyotakeshi.library.domain.repository.CategoryRepository
import com.kiyotakeshi.library.presentation.model.BookDetailResponse
import com.kiyotakeshi.library.presentation.model.BookSummaryResponse
import com.kiyotakeshi.library.presentation.model.ReviewResponse
import com.kiyotakeshi.library.presentation.model.ReviewUserResponse
import org.springframework.stereotype.Service

//
// https://stackoverflow.com/a/28693263
@Service
class BookServiceImpl(
    private val bookRepository: BookRepository,
    private val categoryRepository: CategoryRepository
) : BookService {

    override fun getBooks(): List<BookSummaryResponse> {
        val foundBooks: MutableList<Book> = bookRepository.findAll()

        return foundBooks.map {
            BookSummaryResponse(
                it.id,
                it.title,
                it.author,
                it.published,
                it.categories,
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
            book.author,
            book.published,
            book.categories,
//            listOf(
//                ReviewResponse(
//                    1, "soso", "this is for beginner.", 3.5,
//                    UserResponse(1, "mike")
//                )
//            )
            reviews
        )
    }

    override fun registerBook(book: Book): Book = bookRepository.save(book)

    override fun updateBook(id: Int, request: Book): Book {
        val book = bookRepository.findById(id).orElseThrow()
        book.author = request.author
        book.title = request.title
        book.published = request.published
        return bookRepository.save(book)
    }

    override fun deleteBook(id: Int) = bookRepository.deleteById(id)
}
