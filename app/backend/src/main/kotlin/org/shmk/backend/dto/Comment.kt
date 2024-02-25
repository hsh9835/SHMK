package org.shmk.backend.dto

data class Comment (
    val boardSeq: Number,
    val comment_Seq: Number,
    val comment_content: String,
    val subSeq: String?,
    val comment_hashtag: List<String>,
    val like_count: Number,
    val hate_count: Number,
    val userName: String
)
/*
"boardSeq": "number",
"comment_Seq": "number",
"comment_content": "string",
"subSeq": "string|undefined",
"comment_hashtag": ["@string", "@string", "@string"],
"like_count": "number",
"hate_count": "number",
"userName" : "string" // reg_id 참고해서 불러올것
*/