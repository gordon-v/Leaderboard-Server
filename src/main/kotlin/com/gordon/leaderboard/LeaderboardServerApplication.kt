package com.gordon.leaderboard

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication(exclude = [SecurityAutoConfiguration::class, UserDetailsServiceAutoConfiguration::class])
class LeaderboardServerApplication


fun main(args: Array<String>) {
    runApplication<LeaderboardServerApplication>(*args)
}
