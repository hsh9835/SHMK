package org.shmk.backend.service

import org.shmk.backend.entity.MainComment

interface CommentService {
    fun getBoardComments(boardSeq: Long): List<MainComment>
    fun getBoardUserComments(userSeq: Long): List<MainComment>
    fun saveComment(commentInfo: MainComment): MainComment
    fun updateComment(commentInfo: MainComment): MainComment

}