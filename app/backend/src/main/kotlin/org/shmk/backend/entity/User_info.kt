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
    @Column(name = "ID", nullable = false, length = 20)
    val id: String,

    @Comment("PW")
    @Column(nullable = false, length = 64)
    val password: String,

    @Comment("닉네임")
    @Column(nullable = false)
    val nickname: Number,
)