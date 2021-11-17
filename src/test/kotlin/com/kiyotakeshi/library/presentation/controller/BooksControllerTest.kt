//package com.kiyotakeshi.library.presentation.controller
//
//import com.fasterxml.jackson.databind.ObjectMapper
//import com.fasterxml.jackson.module.kotlin.registerKotlinModule
//import com.kiyotakeshi.library.domain.Book
//import com.kiyotakeshi.library.usecase.BookService
//import com.nhaarman.mockitokotlin2.mock
//import com.nhaarman.mockitokotlin2.whenever
//import org.assertj.core.api.Assertions.assertThat
//import org.junit.jupiter.api.Test
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
//import org.springframework.boot.test.mock.mockito.MockBean
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers
//import org.springframework.test.web.servlet.setup.MockMvcBuilders
//import java.nio.charset.StandardCharsets
//import java.time.LocalDate
//
// TODO: kotlin でのテストの書き方調べる
//@WebMvcTest
//@AutoConfigureMockMvc
//internal class BooksControllerTest {
//
//    private val bookService = mock<BookService>()
//    private val booksController = BooksController(bookService)
//
//    @Test
//    fun `getBooks is success`() {
//        val bookId = 100
//        val book = Book(bookId, "kotlin beginner", "mike", LocalDate.now())
//        val bookList = listOf(book)
//
//        whenever(bookService.getBooks()).thenReturn(bookList)
//
//        val expectedResponse = listOf(Book(bookId, "kotlin beginner", "mike", LocalDate.now()))
//        val expected: String = ObjectMapper().registerKotlinModule().writeValueAsString(expectedResponse)
//        val mockMvc = MockMvcBuilders.standaloneSetup(booksController).build()
//
//        val result = mockMvc.perform(MockMvcRequestBuilders.get("/books"))
//            .andExpect(MockMvcResultMatchers.status().isOk)
//            .andReturn().response.getContentAsString(StandardCharsets.UTF_8)
//
//        assertThat(expected).isEqualTo(result)
//    }
//}