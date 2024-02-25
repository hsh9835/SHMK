package org.shmk.backend.dto

data class BoardUpdate (
    val boardSeq: Int,
    val title: String,
    val hashtag: List<String>,
    val username: String,
    val content: String
)

/*
{
  "boardSeq": "number",
  "title": "string",
  "hashtag": ["@string", "@string", "@string"],
  "username": "string",
  "content": "string",
}
*/