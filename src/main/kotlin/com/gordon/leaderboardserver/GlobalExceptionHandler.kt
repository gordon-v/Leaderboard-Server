package com.gordon.leaderboardserver

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus

@ControllerAdvice
class GlobalExceptionHandler {
    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "User could not be found!")
    @ExceptionHandler(UserNotFound::class)
    fun userNotFound(exception: UserNotFound){}
}