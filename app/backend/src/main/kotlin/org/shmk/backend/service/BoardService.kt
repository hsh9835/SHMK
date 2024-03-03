
import org.shmk.backend.entity.MainBoard
import org.shmk.backend.repository.BoardRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

@Service
class BoardService(private val boardRepository: BoardRepository) {

    fun getAllBoards(pageable: Pageable): Page<MainBoard> {
        return boardRepository.findAll(pageable)
    }

    fun getBoardById(id: Long): Optional<MainBoard> {
        return boardRepository.findById(id)
    }

    fun saveBoard(board: MainBoard): MainBoard {
        return boardRepository.save(board)
    }

    fun updateBoard(id: Long, updatedBoard: MainBoard): MainBoard {
        // ID에 해당하는 게시판 찾기
        val beforeBoard = boardRepository.findById(id)
        // 게시판 찾기, 없으면 NoSuchElementException 예외
        val existingBoard = beforeBoard.orElseThrow { NoSuchElementException("Board not found with id: $id") }
        // 제목, 내용, 해시태그 업데이트
        existingBoard.title = updatedBoard.title
        existingBoard.content = updatedBoard.content
        existingBoard.hashtagList = updatedBoard.hashtagList
        return boardRepository.save(existingBoard)
    }

    fun deleteBoard(id: Long) {
        if (!boardRepository.existsById(id)) {
            throw NoSuchElementException("Board not found with id: $id")
        }
        boardRepository.deleteById(id)
    }
}
