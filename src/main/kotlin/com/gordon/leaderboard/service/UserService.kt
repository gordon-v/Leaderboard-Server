package com.gordon.leaderboard.service

import com.gordon.leaderboard.controller.CreateUserPayload
import com.gordon.leaderboard.controller.UpdateUserPayload
import com.gordon.leaderboard.entity.User
import com.gordon.leaderboard.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {
    fun create(createUserPayload: CreateUserPayload) {
        val userToSave = User(createUserPayload.username, createUserPayload.highscore)
        userRepository.save(userToSave)
    }

    private fun getByUsername(username: String): User =
        userRepository.findByUsername(username) ?: throw UserNotFoundException("User doesn't exist in db")

    fun updateHighscoreByUsername(username: String, updateUserPayload: UpdateUserPayload) {
        val userToUpdate = getByUsername(username)
        userToUpdate.highscore = updateUserPayload.highscore
        userRepository.save(userToUpdate)
    }

    fun deleteByUsername(username: String) {
        val userToDelete = getByUsername(username)
        userRepository.deleteById(userToDelete.id)
    }

}