package com.gordon.leaderboard.controller

import com.gordon.leaderboard.entity.User
import com.gordon.leaderboard.service.UserService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController(private val userService: UserService) {
    @PostMapping
    fun create(@RequestBody payload: CreateUserPayload): UserResponse{
        val user = userService.create(payload)
        return mapToResponse(user)
    }

    @PatchMapping("/{username}")
    fun updateHighscoreByUsername(@PathVariable username: String, @RequestBody payload: UpdateUserPayload) {
        userService.updateHighscoreByUsername(username, payload)
    }

    @DeleteMapping("{username}")
    fun delete(@PathVariable username: String) {
        userService.deleteByUsername(username)
    }

    fun mapToResponse(user: User): UserResponse = UserResponse(user.username, user.highscore)
}