package org.shmk.backend.controller

import com.nimbusds.jose.shaded.gson.Gson
import org.shmk.backend.entity.MainBoard
import org.shmk.backend.service.BoardService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/board")
class BoardController(private val boardService: BoardService){

    @GetMapping("/jsonTest")
    fun jsonTest(): String {
        val gson = Gson()
        val json = gson.toJson(mapOf("test" to "test"))
        println(json)
        return json
    }

    @GetMapping("/list", produces = ["application/json"])
    fun getAllBoards(): List<MainBoard> {
        return boardService.getAllBoards()
    }

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
}
