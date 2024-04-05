package org.shmk.backend.dto.resp

data class BoardListResp (
    val boardSeq: Long,
    var title: String,
    var hashtag: List<String>,
    var username: String,
    var like_count: Int?,
    var comment_count: Int?
)

// List<BoardListResp>
