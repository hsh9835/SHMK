package org.shmk.backend.repository

import org.shmk.backend.entity.User_info
import org.springframework.data.repository.CrudRepository

abstract class TemplateRepository: CrudRepository<User_info, Int> {

//    fun findByUser(userId: User_info): User_info?
}