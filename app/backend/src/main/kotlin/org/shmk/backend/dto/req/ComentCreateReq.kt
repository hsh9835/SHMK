package org.shmk.backend.dto.req

data class ComentCreateReq (
    val boardSeq: Int,
    val commentSeq: Int?,
    val hashtag: List<String>,
    val username: String,
    val content: String
)