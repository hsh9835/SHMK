package org.shmk.backend.controller

import com.nimbusds.jose.shaded.gson.Gson
import org.shmk.backend.entity.MainBoard
import org.shmk.backend.service.BoardService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

// client 가 요청하는 URL 을 받아오고 싶을 때 Controller 정의

@RestController
class TestController(private val boardService: BoardService) {

//    @GetMapping("/list", produces = ["application/json"])
//    fun getAllBoards(pageable: Pageable): Page<MainBoard> {
//
//        return boardService.getAllBoards(pageable)
//    }

    @GetMapping("/{id}")
    fun getBoardById(@PathVariable id: Long): ResponseEntity<MainBoard> {
        val board = boardService.getBoardById(id)
        return board.map { ResponseEntity.ok().body(it) }
            .orElseGet { ResponseEntity.notFound().build() }
    }

    @PostMapping("/save")
    fun saveBoard(@RequestBody board: MainBoard): ResponseEntity<MainBoard> {
        val savedBoard = boardService.saveBoard(board)
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBoard)
    }

    @PutMapping("/{id}")
    fun updateBoard(@PathVariable id: Long, @RequestBody updatedBoard: MainBoard): ResponseEntity<MainBoard> {
        val updated = boardService.updateBoard(id, updatedBoard)
        return ResponseEntity.ok().body(updated)
    }

    @DeleteMapping("/{id}")
    fun deleteBoard(@PathVariable id: Long): ResponseEntity<Void> {
        boardService.deleteBoard(id)
        return ResponseEntity.noContent().build()
    }

    // GET 방식
    @GetMapping("/hello") // localhost:8999/hello 요청 시 Controller 가 요청을 받음
    fun hello(model: Model): Int{
        //model.addAttribute("data","hello, world!")  model 을 가공
        return 123 // HTML 파일 경로를 viewResolver 에 전달 (resources/templates 폴덩서 전달받은 model 을 가공하여 html 파일 변환 예정)
    }

    @GetMapping("/jsonTest2")
    fun jsonTest(): String {
        val gson = Gson()
        val json = gson.toJson(mapOf("test" to "test"))
        return json
    }

}