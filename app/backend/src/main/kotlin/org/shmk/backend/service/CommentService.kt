package org.shmk.backend.service

import org.shmk.backend.entity.MainComment
import org.shmk.backend.repository.BoardRepository
import org.shmk.backend.repository.CommentRepository
import org.shmk.backend.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class CommentService(private val commentRepository: CommentRepository,
                    private val userRepository: UserRepository
                    , private val boardRepository: BoardRepository) {

    // 조회
    fun getBoardComments(boardSeq: Long): List<MainComment> {
        return commentRepository.findByBoardSeq(boardSeq)
    }

    fun getBoardUserComments(userSeq: Long): List<MainComment> {
        return commentRepository.findByRegId(userSeq)
    }

    // CRUD
    fun saveComment(commentInfo: MainComment): MainComment {
        return commentRepository.save(commentInfo)
    }

    fun updateComment(commentInfo: MainComment): MainComment {
        return commentRepository.save(commentInfo)
    }

}