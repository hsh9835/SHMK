package org.shmk.backend.config

import io.swagger.models.Info
import org.springframework.context.annotation.Bean
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket

//@Configuration
class SwaggerConfig {

    @Bean
    fun api(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.any())
//            .paths(PathSelectors.any())
            .paths(PathSelectors.ant("/**/api/**"))
            .build()
    }
    /*
    @Bean
    fun openAPI(): OpenAPI {
        val jwt = "JWT"
        val securityRequirement: SecurityRequirement = SecurityRequirement().addList(jwt)
        val components: Components = Components().addSecuritySchemes(
            jwt, SecurityScheme()
                .name(jwt)
                .type(SecuritySchemeType.HTTP)
                .scheme("bearer")
                .bearerFormat("JWT")
        )
        return OpenAPI()
            .components(Components())
//            .addSecurityItem(securityRequirement)
            .components(components)
    }*/

    private fun apiInfo(): Info {
        return Info()
            .title("API Test") // API의 제목
            .description("Let's practice Swagger UI") // API에 대한 설명
            .version("1.0.0") // API의 버전
    }
}