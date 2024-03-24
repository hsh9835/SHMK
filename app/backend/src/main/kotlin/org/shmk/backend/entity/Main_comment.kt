package org.shmk.backend.entity

import jakarta.persistence.*
import lombok.NoArgsConstructor
import org.hibernate.annotations.Comment
import java.time.LocalDateTime

@Entity
@NoArgsConstructor
@Table(name = "main_comment")
@Comment("게시물 댓글")
data class MainComment (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq", nullable = false, columnDefinition = "int auto_increment")
    val comment_Seq: Int? = null,

    @Comment("게시판 번호")
    @Column(name = "board_seq", nullable = false, columnDefinition = "int")
    val boardSeq: Long? = null,

    @Comment("댓글 내용")
    @Column(name = "content", columnDefinition = "varchar(5000)")
    val comment_content: String? = null,

    @Comment("서브 시퀀스")
    @Column(name = "sub_seq", columnDefinition = "int")
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
    @Column(name = "REG_ID", nullable = false, columnDefinition = "varchar(20)")
    val regId: String? = null,

    @Comment("수정 날짜")
    @Column(name = "UPD_DT", columnDefinition = "datetime")
    val updDt: LocalDateTime? = null,

    @Comment("수정인")
    @Column(name = "UPD_ID", columnDefinition = "varchar(20)")
    val updId: String? = null,

    // 관계 설정
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "board_seq", insertable = false, updatable = false)
//    val mainBoard: MainBoard,
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "REG_ID", referencedColumnName = "id", insertable = false, updatable = false)
//    val regUserInfo: User_info,
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "UPD_ID", referencedColumnName = "id", insertable = false, updatable = false)
//    val updUserInfo: User_info
)
/*
indexes = [
        Index(name = "idx_board_seq", columnList = "board_seq")
    ],
    uniqueConstraints = [
        UniqueConstraint(name = "uk_sub_seq", columnNames = ["sub_seq"])
    ],
*/