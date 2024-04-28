package org.shmk.backend.repository

import org.shmk.backend.entity.MainBoard
import org.shmk.backend.entity.MainComment
import org.springframework.data.jpa.repository.JpaRepository

interface BoardRepository : JpaRepository<MainBoard, Long> {
    // CRUD
    fun findAllByCommentLst(boardSeq: Long): List<MainComment>
    // 특정 page
//    override fun findById(id: Long): Optional<MainBoard>

    // total page
//    override fun findAll(pageable: Pageable): Page<MainBoard>
    // update
//    fun save(board: MainBoard): MainBoard
    // delete
//    override fun deleteById(id: Long)

}