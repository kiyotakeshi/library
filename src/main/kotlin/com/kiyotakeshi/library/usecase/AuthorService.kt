package com.kiyotakeshi.library.usecase

import com.kiyotakeshi.library.presentation.model.BookSummaryResponse

interface AuthorService {
    fun getBooksByAuthor(authorId: Int): List<BookSummaryResponse>
}
