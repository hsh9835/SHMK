package org.shmk.backend.controller

import org.shmk.backend.dto.BoardUpdate
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

// client 가 요청하는 URL 을 받아오고 싶을 때 Controller 정의

@RestController
class TestController {

    // GET 방식
    @GetMapping("/hello") // localhost:8999/hello 요청 시 Controller 가 요청을 받음
    fun hello(model: Model): Int{
        //model.addAttribute("data","hello, world!")  model 을 가공
        return 123 // HTML 파일 경로를 viewResolver 에 전달 (resources/templates 폴덩서 전달받은 model 을 가공하여 html 파일 변환 예정)
    }
}