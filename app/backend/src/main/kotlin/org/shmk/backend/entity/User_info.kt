package org.shmk.backend.entity

import jakarta.persistence.*
import lombok.NoArgsConstructor
import org.hibernate.annotations.Comment

@Entity
@NoArgsConstructor
@Comment("유저 정보")
@Table(name = "user_info")
data class User_info(
    @Id
    @Comment("ID")
    @Column(length = 20)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,

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