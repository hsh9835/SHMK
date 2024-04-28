package org.shmk.backend.service

import org.shmk.backend.dto.resp.BoardListResp
import org.shmk.backend.entity.MainBoard

interface BoardService {
    fun getAllBoards(page: Int, size: Int): List<BoardListResp>
    fun getBoardById(id: Long): MainBoard?
    fun saveBoard(board: MainBoard): MainBoard
    fun updateBoard(id: Long, updatedBoard: MainBoard): MainBoard
    fun deleteBoard(id: Long)
//    fun findAllByCommentLst(boardSeq: Long): List<MainComment>
}