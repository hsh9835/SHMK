
import jakarta.persistence.*
import org.hibernate.annotations.Comment
import org.shmk.backend.entity.MainBoard
import org.shmk.backend.entity.User_info
import java.time.LocalDateTime

@Entity
@Table(name = "main_comment")
@Comment("게시물 댓글")
data class MainComment (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq", nullable = false, columnDefinition = "int auto_increment")
    val seq: Int? = null,

    @Comment("게시판 번호")
    @Column(name = "board_seq", nullable = false, columnDefinition = "int")
    val boardSeq: Int? = null,

    @Comment("댓글 내용")
    @Column(name = "content", columnDefinition = "varchar(5000)")
    val content: String? = null,

    @Comment("서브 시퀀스")
    @Column(name = "sub_seq", columnDefinition = "int")
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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_seq", insertable = false, updatable = false)
    val mainBoard: MainBoard,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REG_ID", insertable = false, updatable = false)
    val userInfo: User_info

    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "UPD_ID", insertable = false, updatable = false)
    //val userInfo: UserInfo
)
/*
indexes = [
        Index(name = "idx_board_seq", columnList = "board_seq")
    ],
    uniqueConstraints = [
        UniqueConstraint(name = "uk_sub_seq", columnNames = ["sub_seq"])
    ],
*/