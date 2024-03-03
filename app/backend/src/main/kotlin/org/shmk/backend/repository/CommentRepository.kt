package org.shmk.backend.repository

import org.shmk.backend.entity.MainComment
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface CommentRepository : JpaRepository<MainComment, Int> {
    override fun findById(id: Int): Optional<MainComment>

    // total page
    override fun findAll(pageable: Pageable): Page<MainComment>
    // update
    fun save(board: MainComment): MainComment
    // delete
    override fun deleteById(id: Int)
}