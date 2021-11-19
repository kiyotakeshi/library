package com.kiyotakeshi.library

import org.apache.commons.io.FileUtils
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MvcResult
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext
import java.io.File
import java.nio.charset.Charset

import java.nio.charset.StandardCharsets

@SpringBootTest
class GenerateOasFile {

    @Value("\${server.port}")
    private lateinit var portNumber: String

    @Autowired
    protected var context: WebApplicationContext? = null

    @Test
    fun generateOasFile() {
        val mockMvc = MockMvcBuilders.webAppContextSetup(context!!).build()

        mockMvc.perform(get("http://localhost:${portNumber}/v3/api-docs").contentType(MediaType.APPLICATION_JSON))
            // .andDo(MockMvcResultHandlers.print())
            .andDo { result: MvcResult ->
                FileUtils.writeStringToFile(
                    // File("build/docs/oas.json"),
                    File("openapi/openapi.json"),
                    String(result.response.contentAsByteArray, StandardCharsets.UTF_8),
                    Charset.defaultCharset(),
                    false
                )
            }
        }
}