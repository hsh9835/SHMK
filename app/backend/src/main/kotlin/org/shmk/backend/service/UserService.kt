package org.shmk.backend.service

import org.shmk.backend.entity.User_info
import org.shmk.backend.repository.UserRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(private val userRepository: UserRepository) {

    // 조회
    fun getAllUsers(): List<User_info> {
        return userRepository.findAll()
    }

    fun getUserById(id: Long): Optional<User_info> {
        return userRepository.findById(id)
    }

    // CRUD
    fun saveUser(userInfo: User_info): User_info {
        return userRepository.save(userInfo)
    }

    fun updateUser(id: Long, updateUser: User_info): User_info {
        // 비밀번호 확인 로직, 닉네임 중복체크 로직 추가 필요
        var existUser = userRepository.findById(id).get()
        existUser.password = updateUser.password
        existUser.nickname = updateUser.nickname
        return userRepository.save(existUser)
    }

    fun deleteUser(id: Long) {
        return userRepository.deleteById(id)
    }
}