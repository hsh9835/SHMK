package org.shmk.backend.repository

import org.shmk.backend.entity.User_info
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User_info, Long> {
    // CRUD

    // 특정 id 조회
//    override fun findById(id: Long): Optional<User_info>

    // 생성 및 수정
//    fun save(userInfo: User_info): User_info

    // 삭제
//    override fun deleteById(id: Long)

    // 전체 조회
//    override fun findAll(): MutableList<User_info>

    // 특정 컬럼 값으로 조회: 등록인 id로 조회
   // fun findByRegId(id: Long): List<MainComment>
}