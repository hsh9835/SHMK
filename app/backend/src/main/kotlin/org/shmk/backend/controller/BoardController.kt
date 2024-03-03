
import org.shmk.backend.entity.MainBoard
import org.shmk.backend.service.BoardService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/board")
class BoardController() {

    @Autowired
    private lateinit var boardService: BoardService

    @GetMapping("/jsonTest")
    fun jsonTest(): Map<String, Any> {
        return mapOf("hello" to "world")
    }

    @GetMapping("/list", produces = ["application/json"])
    fun getAllBoards(@RequestParam(required = false, defaultValue = "") pageable: Pageable): Page<MainBoard> {

        val board = boardService.getAllBoards(pageable)
        print(board)
        return board
    }


    @GetMapping("/{id}")
    fun getBoardById(@PathVariable id: Long): ResponseEntity<MainBoard> {
        val board = boardService.getBoardById(id)
        return if (board.isPresent) {
            ResponseEntity.ok().body(board.get())
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @PostMapping("/save")
    fun saveBoard(@RequestBody board: MainBoard): ResponseEntity<MainBoard> {
        val savedBoard = boardService.saveBoard(board)
        print(savedBoard)
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
