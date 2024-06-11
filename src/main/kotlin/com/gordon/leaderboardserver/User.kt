package com.gordon.leaderboardserver

import jakarta.persistence.*

@Entity
@Table(name = "users")
data class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    @Column(name = "username", unique = true, nullable = false)
    var username: String,
    @Column(name = "highscore", unique = false, nullable = false)
    var highscore: String
){
    constructor(
        username: String,
        highscore: String
    ) : this(
        0L, username, highscore
    )
}
