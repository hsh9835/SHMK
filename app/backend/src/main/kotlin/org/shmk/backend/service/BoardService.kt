package org.shmk.backend.service

import org.shmk.backend.dto.resp.BoardListResp
import org.shmk.backend.entity.MainBoard
import org.shmk.backend.entity.MainComment
import org.shmk.backend.entity.User_info
import org.shmk.backend.repository.BoardRepository
import org.shmk.backend.repository.CommentRepository
import org.shmk.backend.repository.UserRepository
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import java.util.*

@Service
class BoardService(private val boardRepository: BoardRepository,
                    private val userRepository: UserRepository,
                    private val commentRepository: CommentRepository) {

    fun getAllBoards(page:Int, size: Int): List<BoardListResp> {
        val pageResult: List<MainBoard> = boardRepository.findAll(PageRequest.of(page, size)).content

        val result: List<BoardListResp> = pageResult.map { board ->
            val user:User_info = userRepository.findById(board.seqUser).orElse(null)
            val commentLst: List<MainComment> = commentRepository.findByBoardSeq(board.boardSeq)

            BoardListResp(
                boardSeq = board.boardSeq,
                title = board.title,
                hashtag = board.hashtag,
                username = user?.nickname ?: "Unknown",
                like_count = board.like_count,
                comment_count = commentLst.size
            )
        }
        return result
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
        existingBoard.hashtag = updatedBoard.hashtag
        return boardRepository.save(existingBoard)
    }

    fun deleteBoard(id: Long) {
        if (!boardRepository.existsById(id)) {
            throw NoSuchElementException("Board not found with id: $id")
        }
        boardRepository.deleteById(id)
    }
}
