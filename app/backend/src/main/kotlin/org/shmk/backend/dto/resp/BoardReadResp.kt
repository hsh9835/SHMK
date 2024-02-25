package org.shmk.backend.dto.resp

import org.shmk.backend.dto.Comment

data class BoardReadResp(
    val title: String,
    val hashtag: List<String>,
    val username: String,
    val like_count: Int,
    val hate_count: Int,
    val content: String,
    val comment: List<Comment>
)