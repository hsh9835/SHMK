
import org.shmk.backend.entity.MainBoard
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/board")
class BoardController(private val boardService: BoardService) {

    @GetMapping
    fun getAllBoards(pageable: Pageable): ResponseEntity<Page<MainBoard>> {
        val boards = boardService.getAllBoards(pageable)

        return ResponseEntity.ok().body(boards)
//        return ResponseEntity.ok().body(boardDTOs)
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

    @PostMapping
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
