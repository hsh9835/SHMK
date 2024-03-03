package org.shmk.backend.repository

import org.shmk.backend.entity.User_info
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User_info, Long> {
}