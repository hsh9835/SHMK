package org.shmk.backend.entity

import jakarta.persistence.*
import lombok.NoArgsConstructor
import org.hibernate.annotations.Comment
import java.time.LocalDateTime

@Entity
@NoArgsConstructor
@Table(name = "main_board")
data class MainBoard(
    // 변경 가능성이 있는 필드 var (getter, setter), 없는 필드 val (Only getter)
    @Id
    @Comment("게시판 시퀀스")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val seq: Long? = null,

    @Comment("게시물 제목")
    @Column(nullable = false, length = 50)
    var title: String,

    @Comment("게시물 내용")
    @Column(length = 5000)
    var content: String? = null,

    @Comment("해시태그 시퀀스")
    @Column(name = "seq_hashtag", nullable = false)
    val seqHashtag: Long,

    @Comment("유저 시퀀스")
    @Column(name = "seq_user", nullable = false)
    val seqUser: Long,

    @Comment("추천수")
    @Column(name = "like_count")
    var likeCount: Int? = null,

    @Column(name = "hate_count")
    var hateCount: Int? = null,

    @Column(name = "seq_comment")
    val seqComment: Long? = null,

    @Comment("생성날짜")
    @Column(name = "REG_DT", nullable = false)
    val regDt: LocalDateTime,

    @Comment("생성 주체 ID")
    @Column(name = "REG_ID", nullable = false, length = 20)
    val regId: String,

    @Column(name = "UPD_DT")
    var updDt: LocalDateTime? = null,

    @Column(name = "UPD_ID", length = 20)
    val updId: String? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REG_ID", insertable = false, updatable = false)
    val regUser: User_info,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UPD_ID", insertable = false, updatable = false)
    val updUser: User_info
)
