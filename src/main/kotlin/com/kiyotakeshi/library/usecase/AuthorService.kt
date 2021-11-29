package com.kiyotakeshi.library.usecase

import com.kiyotakeshi.library.presentation.model.AuthorResponse
import com.kiyotakeshi.library.presentation.model.BookSummaryResponse

interface AuthorService {
    fun getAuthors(): List<AuthorResponse>
    fun getBooksByAuthor(authorId: Int): List<BookSummaryResponse>
}
