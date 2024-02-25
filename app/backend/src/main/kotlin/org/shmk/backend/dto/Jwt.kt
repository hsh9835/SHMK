package org.shmk.backend.dto

data class Jwt (
    var acs: String,
    val ref: String
)

/*
"acs": "string" // access token
"ref": "string" // refresh token
 */