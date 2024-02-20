package org.shmk.backend.controller

import org.shmk.backend.dto.req.LoginReq
import org.springframework.http.MediaType
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class LoginController {
    @ResponseBody
    @PostMapping("/login", consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun login(@RequestBody request: LoginReq): String {

        // user login info
        val id = request.id
        val pw = request.pw
        return "jwt"
    }
}