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
    val commentSeq: Int? = null,

    @Comment("게시판 번호")
    @ManyToOne
    @JoinColumn(name = "board_seq"
        , nullable = false
        , referencedColumnName = "board_seq"
    )
    val boardSeq: MainBoard,

    @Comment("댓글 내용")
    @Column(name = "content", columnDefinition = "varchar(5000)")
    val commentContent: String? = null,

    @Comment("서브 시퀀스")
    @JoinColumn(name = "sub_seq", columnDefinition = "int")
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

    @Comment("생성 날짜")
    @Column(name = "REG_DT", nullable = false)
    var regDt: LocalDateTime? = null,

    @Comment("생성 주체 ID")
    @ManyToOne
    @JoinColumn(name = "REG_ID", referencedColumnName = "ID", nullable = false)
    val regId: User_info,

    @Comment("수정 날짜")
    @Column(name = "UPD_DT")
    var updDt: LocalDateTime? = null,

    @Comment("수정 주체 ID")
    @ManyToOne
    @JoinColumn(name = "UPD_ID", referencedColumnName = "ID")
    val updId: User_info? = null,

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