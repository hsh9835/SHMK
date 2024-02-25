package org.shmk.backend.dto.resp

data class BoardListResp (
    val boardSeq: Int,
    val title: String,
    val hashtag: List<String>,
    val username: String,
    val like_count: Int,
    val comment_count: Int
)

// List<BoardListResp>
