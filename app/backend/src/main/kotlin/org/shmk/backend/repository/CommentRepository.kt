package org.shmk.backend.repository

import org.shmk.backend.entity.MainComment
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface CommentRepository : JpaRepository<MainComment, Int> {

    // 특정 댓글 조회
    override fun findById(id: Int): Optional<MainComment>

    // 생성 및 수정
    fun save(comment: MainComment): MainComment
    // delete
    override fun deleteById(id: Int)

    // 특정 컬럼 값으로 조회: 등록인 id로 조회
    fun findByRegId(regId: Long): List<MainComment>

    fun findByBoardSeq(boardSeq: Long): List<MainComment>
}