import org.shmk.backend.dto.resp.BoardListResp
import org.shmk.backend.entity.MainBoard
import org.shmk.backend.repository.BoardRepository
import org.shmk.backend.repository.CommentRepository
import org.shmk.backend.service.BoardService
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

@Service
class BoardServiceImpl(
    private val boardRepository: BoardRepository,
    private val commentRepository: CommentRepository,
) : BoardService {

    override fun getAllBoards(page: Int, size: Int): List<BoardListResp> {
        val pageResult = boardRepository.findAll(PageRequest.of(page, size)).content

        return pageResult.map { board ->
            val user = board.seqUser?.nickname ?: throw NoSuchElementException("User not found")
            val commentCount = boardRepository.findAllByCommentLst(board.boardSeq)

            BoardListResp(
                boardSeq = board.boardSeq,
                title = board.title,
                hashtag = board.hashtag,
                username = user,
                like_count = board.like_count,
                comment_count = commentCount.size
            )
        }
    }

    override fun getBoardById(id: Long): MainBoard? {
        return boardRepository.findById(id).orElse(null)
    }

    override fun saveBoard(board: MainBoard): MainBoard {
        return boardRepository.save(board)
    }

    override fun updateBoard(id: Long, updatedBoard: MainBoard): MainBoard {
        val existingBoard = boardRepository.findById(id).orElseThrow { NoSuchElementException("Board not found with id: $id") }
        existingBoard.apply {
            title = updatedBoard.title
            content = updatedBoard.content
            hashtag = updatedBoard.hashtag
        }
        return boardRepository.save(existingBoard)
    }

    override fun deleteBoard(id: Long) {
        if (!boardRepository.existsById(id)) {
            throw NoSuchElementException("Board not found with id: $id")
        }
        boardRepository.deleteById(id)
    }
}
