package com.gordon.leaderboardserver

data class UserNotFound(override val message: String?): Exception(message)
