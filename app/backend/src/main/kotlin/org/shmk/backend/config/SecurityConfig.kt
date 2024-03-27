package org.shmk.backend.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer
import org.springframework.security.config.annotation.web.configurers.CorsConfigurer
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer
import org.springframework.security.web.SecurityFilterChain
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
@EnableWebSecurity
class SecurityConfig: WebMvcConfigurer {

    override fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping("/**")
            .allowedOrigins("*")
            .allowedMethods("GET", "POST", "PUT", "DELETE")
    }

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        val corsConfiguration = CorsConfiguration().apply {
            allowedOrigins = listOf("*")
            allowedMethods = listOf("GET", "POST", "PUT", "DELETE")
        }

        http
            .csrf().disable() // CSRF 토큰 검증 비활성화
            .cors { it.configurationSource { corsConfiguration } }
            .authorizeRequests { authorizeRequests ->
                authorizeRequests.anyRequest().permitAll()
            }
            .apply(HttpBasicConfigurer<HttpSecurity>()).disable() // Basic 인증 비활성화
        return http.build()
    }
}