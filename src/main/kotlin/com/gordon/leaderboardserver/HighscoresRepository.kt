package com.gordon.leaderboardserver

import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface HighscoresRepository : JpaRepository<User, Long> {
    //fun findTopByPage (page: Pageable): Optional<List<HighscoreResponse>>
}