package com.gordon.leaderboardserver

import org.springframework.data.jpa.repository.JpaRepository


interface HighscoresRepository : JpaRepository<User, Long> {
}