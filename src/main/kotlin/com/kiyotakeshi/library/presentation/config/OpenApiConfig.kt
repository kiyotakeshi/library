package com.kiyotakeshi.library.presentation.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket

@Configuration
class OpenApiConfig {
    @Bean
    fun productApi(): Docket? {
        return Docket(DocumentationType.OAS_30)
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.kiyotakeshi.library.presentation.controller"))
            .apis(RequestHandlerSelectors.any())
            .paths(PathSelectors.any())
            .build()
            .apiInfo(metaData())
            .useDefaultResponseMessages(false)
    }

    private fun metaData(): ApiInfo? {
        return ApiInfoBuilder()
            .title("library")
            .description("Spring Boot REST API using kotlin")
            .version("0.0.1")
            .contact(Contact("kiyotakeshi", "https://github.com/kiyotakeshi/library", "kiyotatakeshi.work@gmail.com"))
            .build()
    }
}
