package com.gordon.leaderboard.controller

data class CreateUserPayload(
    val username: String,
    val highscore: Int
)

data class UpdateUserPayload(
    val highscore: Int
)