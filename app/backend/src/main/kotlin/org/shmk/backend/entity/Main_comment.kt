package org.shmk.backend.entity

import jakarta.persistence.*
import lombok.NoArgsConstructor
import org.hibernate.annotations.Comment
import java.time.LocalDateTime

@Entity
@NoArgsConstructor
@Table(name = "main_comment", indexes = [Index(name = "idx_board_seq", columnList = "boardSeq")],
    uniqueConstraints = [UniqueConstraint(name = "uk_sub_seq", columnNames = ["subSeq"])])
@Comment("게시물 댓글")
//@NamedQuery(name = "MainComment.findByBoardSeq", query = "SELECT m FROM MainComment m WHERE m.boardSeq.boardSeq = ?1")
data class MainComment (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "commentSeq", nullable = false, columnDefinition = "int auto_increment")
    val commentSeq: Long,

    @Comment("게시판 번호")
    @ManyToOne
    @JoinColumn(name = "boardSeq", referencedColumnName = "boardSeq", nullable = false)
    val boardSeq: MainBoard,

    @Comment("댓글 내용")
    @Column(name = "content", columnDefinition = "varchar(5000)")
    val commentContent: String? = null,

    @Comment("서브 시퀀스")
    @Column(name = "subSeq", columnDefinition = "int")
    val subSeq: Int? = null,

    @Comment("댓글 해시태그")
    @Column(name = "comment_hashtag", columnDefinition = "varchar(21)")
    val commentHashtag: String? = null,

    @Comment("추천 수")
    @Column(name = "like_count", columnDefinition = "int")
    val likeCount: Int? = null,

    @Comment("싫어요 수")
    @Column(name = "hate_count", columnDefinition = "int")
    val hateCount: Int? = null,

    @Comment("등록 날짜")
    @Column(name = "REG_DT", nullable = false, columnDefinition = "datetime")
    val regDt: LocalDateTime,

    @Comment("등록인")
//    @ManyToOne
//    @JoinColumn(name = "regId", referencedColumnName = "userID", nullable = false)
    val regId: User_info,

    @Comment("수정 날짜")
    @Column(name = "UPD_DT", columnDefinition = "datetime")
    val updDt: LocalDateTime? = null,

    @Comment("수정인")
//    @ManyToOne
//    @JoinColumn(name = "updId", referencedColumnName = "userID")
    val updId: User_info,
)
