package org.shmk.backend.entity

import jakarta.persistence.*
import lombok.NoArgsConstructor
import org.hibernate.annotations.Comment
import java.time.LocalDateTime

@Entity
@NoArgsConstructor
@Table(name = "main_board")
data class  MainBoard(
    // 변경 가능성이 있는 필드 var (getter, setter), 없는 필드 val (Only getter)
    @Id
    @Comment("게시판 시퀀스")
    @Column(nullable = false, name = "boardSeq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val boardSeq: Long,

    @Comment("게시물 제목")
    @Column(nullable = false, length = 50)
    var title: String,

    @Comment("게시물 내용")
    @Column(length = 5000)
    var content: String? = null,

    @Comment("해시태그 리스트")
    @Column(name = "hashtag_list", nullable = false)
    var hashtag: List<String>,

    @ManyToOne(fetch = FetchType.LAZY)
    @Comment("유저 시퀀스")
    @JoinColumn(name = "seqUser", referencedColumnName = "ID", nullable = false)
    val seqUser: User_info?,

    @Comment("추천수")
    @Column(name = "like_count")
    var like_count: Int? = null,

    @Column(name = "hate_count")
    var hate_count: Int? = null,

    @Column(name = "seq_comment")
    val seqComment: List<Long>? = null,

    @Comment("생성날짜")
    @Column(name = "REG_DT", nullable = false)
    var regDt: LocalDateTime? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @Comment("생성 주체 ID")
    @JoinColumn(name = "regId", referencedColumnName = "ID", nullable = false)
    val regId: User_info,

    @Column(name = "UPD_DT")
    var updDt: LocalDateTime? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "updId", referencedColumnName = "ID")
    val updId: User_info? = null,

    @OneToMany(mappedBy = "boardSeq", cascade = [CascadeType.ALL], orphanRemoval = true)
    var commentLst: List<MainComment>? = null,

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "REG_ID", insertable = false, updatable = false)
//    val regUser: User_info,
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "UPD_ID", insertable = false, updatable = false)
//    val updUser: User_info
){
    init {
        if(like_count == null){
            like_count = 0
        }
        if(hate_count == null){
            hate_count = 0
        }
        if(regDt == null){
            regDt = LocalDateTime.now()
        }
        commentLst = ArrayList<MainComment>()
    }
}
