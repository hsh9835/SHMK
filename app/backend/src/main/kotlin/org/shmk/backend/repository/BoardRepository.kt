package org.shmk.backend.repository

import org.shmk.backend.entity.MainBoard
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface BoardRepository : JpaRepository<MainBoard, Long> {
    // CRUD

    // 특정 page
    override fun findById(id: Long): Optional<MainBoard>

    // total page
    override fun findAll(pageable: Pageable): Page<MainBoard>
    // update
    fun save(board: MainBoard): MainBoard
    // delete
    override fun deleteById(id: Long)

}