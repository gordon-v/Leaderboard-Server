package com.gordon.leaderboard.repository

import com.gordon.leaderboard.entity.User
import org.springframework.data.jpa.repository.JpaRepository


interface HighscoresRepository : JpaRepository<User, Long> {
}