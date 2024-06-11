package com.gordon.leaderboardserver

import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {
    fun create(createUserPayload: CreateUserPayload) {
        val userToSave = User(createUserPayload.username, createUserPayload.highscore)
        userRepository.save(userToSave)
    }

    private fun getByUsername(username: String): User =
        userRepository.findByUsername(username) ?: throw IllegalArgumentException("username not found")

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