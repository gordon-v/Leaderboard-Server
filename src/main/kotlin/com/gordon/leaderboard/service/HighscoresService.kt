package com.gordon.leaderboard.service
import com.gordon.leaderboard.controller.HighscoreResponse
import com.gordon.leaderboard.repository.HighscoresRepository
import com.gordon.leaderboard.entity.User
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service


@Service

class HighscoresService(private val highscoresRepository: HighscoresRepository) {

    fun getByPage(page: Pageable): List<HighscoreResponse> =
        highscoresRepository.findAll(page).map(::mapUserToResponse).toList()

    fun mapUserToResponse(user: User): HighscoreResponse = HighscoreResponse(user.username, user.highscore)
}