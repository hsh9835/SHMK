package org.shmk.backend.dto.req

data class BoardCreateReq (
    val title: String,
    val hashtag: List<String>,
    val username: String,
    val content: String
)
