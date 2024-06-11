package com.gordon.leaderboardserver

import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/highscores")
class HighscoresController(private val highscoresService: HighscoresService) {
    @GetMapping()
    fun getByPage(
        @RequestParam(defaultValue = "5", required = false) pageSize: Int,
        @RequestParam(defaultValue = "0", required = false) page: Int
    ): List<HighscoreResponse> {
        val paging: Pageable = PageRequest.of(page, pageSize)
        return highscoresService.getByPage(paging)
    }
}