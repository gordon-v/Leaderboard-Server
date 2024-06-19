package com.gordon.leaderboard

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LeaderboardServerApplication

fun main(args: Array<String>) {
    runApplication<LeaderboardServerApplication>(*args)
}
