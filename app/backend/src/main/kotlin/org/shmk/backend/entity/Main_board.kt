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
    /**
     * DB 값에 List를 넣을 수 없음
     * 2024.05.03 홍세화
     */
    var hashtag: String,

//    @ManyToOne
    @Comment("유저 시퀀스")
//    @JoinColumn(name = "seqUser", referencedColumnName = "userID", nullable = false)
    val seqUser: String,

    @Comment("좋아요 수")
    @Column(name = "like_count")
    var likeCount: Int? = null,

    @Comment("싫어요 수")
    @Column(name = "hate_count")
    var hateCount: Int? = null,

    /**
     * 존재 의미를 모르겠어서 삭제
     * 2024.05.03 홍세화
     */
//    @Column(name = "seq_comment")
//    val seqComment: List<Long>? = null,

    @Comment("등록 날짜")
    @Column(name = "REG_DT", nullable = false)
    var regDt: LocalDateTime? = null,

//    @ManyToOne
    @Comment("생성 주체 ID")
//    @JoinColumn(name = "regId", referencedColumnName = "userID", nullable = false)
    var regId: String,

    @Column(name = "UPD_DT")
    var updDt: LocalDateTime? = null,

//    @ManyToOne
//    @JoinColumn(name = "updId", referencedColumnName = "userID")
    var updId: String,

    @OneToMany(mappedBy = "boardSeq", cascade = [CascadeType.REMOVE])
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
        if(likeCount == null){
            likeCount = 0
        }
        if(hateCount == null){
            hateCount = 0
        }
        if(regDt == null){
            regDt = LocalDateTime.now()
        }
        commentLst = ArrayList<MainComment>()
    }

    fun checkUser(board: MainBoard, user: User_info) {
        if (!board.seqUser?.equals(user.id)!!) throw Exception()
    }
}
