package org.shmk.backend.service

import org.shmk.backend.entity.User_info
import java.util.*

interface UserService {
    fun getAllUsers(): List<User_info>
    fun getUserById(id: Long): Optional<User_info>
    fun saveUser(userInfo: User_info): User_info
    fun updateUser(id: Long, updateUser: User_info): User_info
    fun deleteUser(id: Long)
}