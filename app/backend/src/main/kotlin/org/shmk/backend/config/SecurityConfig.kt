package org.shmk.backend.config

import org.springframework.context.annotation.Configuration

@Suppress("DEPRECATION")
@Configuration
class SecurityConfig {
    private val allowedUrls = arrayOf("/", "/swagger-ui/**", "/v3/**", "/sign-up", "/sign-in")	// sign-up, sign-in 추가

//    @Bean
//    fun filterChain(http: HttpSecurity) = http
//        .csrf().disable()
//        .headers { it.frameOptions().sameOrigin() }
//        .authorizeHttpRequests {
//            it.requestMatchers(*allowedUrls).permitAll()	// 허용할 url 목록을 배열로 분리했다
//                .requestMatchers(PathRequest.toH2Console()).permitAll()
//                .anyRequest().authenticated()
//        }
//        .and() // 메서드 체인을 종료하고 HttpSecurity 객체 반환
//        .sessionManagement { it.sessionCreationPolicy(SessionCreationPolicy.STATELESS) }
//        .build()!!
}
