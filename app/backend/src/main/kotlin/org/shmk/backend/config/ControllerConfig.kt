package org.shmk.backend.config

import BoardController
import org.shmk.backend.service.BoardService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ControllerConfig(private val boardService: BoardService) {

    @Bean
    fun boardController(): BoardController {
        return BoardController(boardService)
    }

}