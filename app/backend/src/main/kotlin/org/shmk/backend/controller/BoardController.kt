
import com.google.gson.Gson
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.shmk.backend.dto.resp.BoardListResp
import org.shmk.backend.dto.resp.BoardResp
import org.shmk.backend.entity.MainBoard
import org.shmk.backend.service.BoardService
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/board")
class BoardController(private val boardService: BoardService) {

    @GetMapping("/jsonTest")
    fun jsonTest(): String {
        val gson = Gson()
        val json = gson.toJson(mapOf("test" to "test"))
        println(json)
        return json
    }

    // http://localhost:8999/board/list?page=2
    @GetMapping("/list", produces = ["application/json"])
    fun getAllBoards(request: HttpServletRequest
    , response: HttpServletResponse
    , model: Model
    , @RequestParam("page", defaultValue = "0") page: Int
    , pageable: Pageable
    ): List<BoardListResp> {
        return boardService.getAllBoards(page, 5)
    }

    // page
//    @GetMapping("/list/{id}", produces = ["application/json"])
//    fun getBoards(): List<MainBoard> {
//        return boardService.getAllBoards()
//    }

    @GetMapping("/{id}")
    fun getBoardById(@PathVariable id: Long): ResponseEntity<MainBoard> {
        val board = boardService.getBoardById(id)
        return board.map { ResponseEntity.ok().body(it) }
            .orElseGet { ResponseEntity.notFound().build() }
    }

    @PostMapping("/save")
    fun saveBoard(@RequestBody board: MainBoard): ResponseEntity<BoardResp> {
        val savedBoard = boardService.saveBoard(board)
        var newBoard = boardService.getBoardById(savedBoard.boardSeq)
        var isCreated = false;

        if(newBoard != null){
            isCreated = true;
        }
        val jsonReq = BoardResp(isCreated)
        // JsonReq 객체를 ResponseEntity에 담아서 반환합니다.
        return ResponseEntity.status(HttpStatus.CREATED).body(jsonReq)
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
