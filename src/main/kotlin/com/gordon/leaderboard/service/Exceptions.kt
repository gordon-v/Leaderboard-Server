package com.gordon.leaderboard.service

data class UserNotFoundException(override val message: String?): Exception(message)
