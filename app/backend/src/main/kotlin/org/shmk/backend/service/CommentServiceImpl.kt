package org.shmk.backend.service

import jakarta.transaction.Transactional
import org.shmk.backend.entity.MainComment
import org.shmk.backend.entity.User_info
import org.shmk.backend.repository.BoardRepository
import org.shmk.backend.repository.CommentRepository
import org.shmk.backend.repository.UserRepository
import org.springframework.stereotype.Service

@Service
@Transactional
class CommentServiceImpl (private val commentRepository: CommentRepository,
                         private val userRepository: UserRepository
                         , private val boardRepository: BoardRepository) : CommentService {
    override fun getBoardComments(boardSeq: Long): List<MainComment> {
        return boardRepository.findAllByCommentLst(boardSeq)
    }

    // 조회

    override fun getBoardUserComments(userSeq: Long): List<MainComment> {
        val user: User_info? = null
        return commentRepository.findByRegId(user)
    }

    // CRUD
    override fun saveComment(commentInfo: MainComment): MainComment {
        return commentRepository.save(commentInfo)
    }

    override fun updateComment(commentInfo: MainComment): MainComment {
        return commentRepository.save(commentInfo)
    }

}