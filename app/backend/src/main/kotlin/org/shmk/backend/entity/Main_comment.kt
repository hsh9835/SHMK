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
    @Column(name = "seq", nullable = false, columnDefinition = "int auto_increment")
    val comment_Seq: Long,

    @Comment("게시판 번호")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment", referencedColumnName = "boardSeq", nullable = false)
    val boardSeq: MainBoard? = null,

    @Comment("댓글 내용")
    @Column(name = "content", columnDefinition = "varchar(5000)")
    val comment_content: String? = null,

    @Comment("서브 시퀀스")
    @Column(name = "subSeq", columnDefinition = "int")
    val subSeq: Int? = null,

    @Comment("댓글 해시태그")
    @Column(name = "comment_hashtag", columnDefinition = "varchar(21)")
    val comment_hashtag: String? = null,

    @Comment("추천 수")
    @Column(name = "like_count", columnDefinition = "int")
    val like_count: Int? = null,

    @Comment("싫어요 수")
    @Column(name = "hate_count", columnDefinition = "int")
    val hate_count: Int? = null,

    @Comment("등록 날짜")
    @Column(name = "REG_DT", nullable = false, columnDefinition = "datetime")
    val regDt: LocalDateTime? = null,

    @Comment("등록인")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "regId", referencedColumnName = "ID", nullable = false)
    val regId: User_info? = null,

    @Comment("수정 날짜")
    @Column(name = "UPD_DT", columnDefinition = "datetime")
    val updDt: LocalDateTime? = null,

    @Comment("수정인")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "updId", referencedColumnName = "ID")
    val updId: User_info? = null,
)
