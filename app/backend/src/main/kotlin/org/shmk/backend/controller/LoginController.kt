package org.shmk.backend.controller

import org.shmk.backend.dto.req.LoginReq
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
class LoginController {
    @ResponseBody
    @PostMapping("/login", consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun login(@RequestBody request: LoginReq): String {

        // user login info
        val id = request.id
        val pw = request.pw
        return "jwt"
    }

//    @Operation(summary = "회원 가입")
//    @PostMapping("/sign-up")
//    fun signUp(@RequestBody request: SignUpRequest) = ApiResponse.success(signService.registMember(request))
//
//    @Operation(summary = "로그인")
//    @PostMapping("/sign-in")
//    fun signIn(@RequestBody request: SignInRequest) = ApiResponse.success(signService.signIn(request))
}