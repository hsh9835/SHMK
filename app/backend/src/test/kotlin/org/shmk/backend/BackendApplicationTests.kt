package org.shmk.backend

import org.junit.jupiter.api.Test
import org.shmk.backend.dto.Jwt
import org.shmk.backend.entity.User_info
import org.shmk.backend.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class BackendApplicationTests(
    @Autowired
    val userRepository: UserRepository
) {

    @Test
    fun contextLoads() {
        var user_Info:User_info = User_info("hsh980305", "1234", "Sehwa")
        userRepository.save(user_Info)
    }

}
