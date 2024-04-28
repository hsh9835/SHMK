package org.shmk.backend.repository

import org.shmk.backend.entity.MainComment
import org.shmk.backend.entity.User_info
import org.springframework.data.jpa.repository.JpaRepository
interface CommentRepository : JpaRepository<MainComment, Int> {

    fun findByRegId(userSeq: User_info): List<MainComment>

    // 특정 댓글 조회
//    override fun findById(id: Int): Optional<MainComment>

    // 생성 및 수정
//    fun save(comment: MainComment): MainComment
    // delete
//    override fun deleteById(id: Int)


}