package org.shmk.backend.entity

import jakarta.persistence.*
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter
import org.hibernate.annotations.Comment

@Entity
@Getter
@Setter
@Comment("유저 정보")
@Table(name = "user_info")
data class User_info(

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var seq: Long,

    @Comment("ID")
    @Column(name = "userID", length = 20)
    /**
     * ID 값은 사용자가 입력하는 고유의 값
     * 따라서 이 값이 SEQ와 특성이 같은게 아닌데
     * 왜 자동으로 생성하도록 설정했는지
     */
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var userID: String,

    @Comment("userID")
    @Column(nullable = false, length = 20)
    var userID: String,

    @Comment("PW")
    @Column(nullable = true, length = 64)
    var password: String,

    @Comment("닉네임")
    @Column(nullable = false)
    var nickname: String,

    //    @OneToMany(mappedBy = "boardList", fetch = FetchType.LAZY)
//    var boardList: List<MainBoard> = ArrayList()

)