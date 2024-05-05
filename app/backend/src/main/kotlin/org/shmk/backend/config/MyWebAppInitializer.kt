package org.shmk.backend.config

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer

class MyWebAppInitializer : AbstractAnnotationConfigDispatcherServletInitializer() {

    override fun getRootConfigClasses(): Array<Class<*>>? {
        return null
    }

    override fun getServletConfigClasses(): Array<Class<*>>? {
        return arrayOf(WebMvcConfigurer::class.java, SecurityConfig::class.java);
    }

    override fun getServletMappings(): Array<String> {
        return arrayOf("/") // 모든 요청을 디스패처 서블릿으로 매핑
    }
}