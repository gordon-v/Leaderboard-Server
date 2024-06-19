package com.gordon.leaderboard.controller

class CreateUserPayload(
    val username: String,
    val highscore: Int
)

class UpdateUserPayload(
    val highscore: Int
)