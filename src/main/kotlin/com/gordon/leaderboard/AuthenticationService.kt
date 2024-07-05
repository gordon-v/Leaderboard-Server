package com.gordon.leaderboard

import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.stereotype.Service
import javax.servlet.http.HttpServletRequest

@Service
class AuthenticationService {
    private val AUTH_TOKEN_HEADER_NAME: String = "X-API-KEY"
    private val AUTH_TOKEN: String = "leaderboard"

    fun getAuthentication(request: HttpServletRequest): org.springframework.security.core.Authentication{
        val apiKey: String = request.getHeader(AUTH_TOKEN_HEADER_NAME)
        if (apiKey != AUTH_TOKEN){
            throw BadCredentialsException("Invalid API key")
        }
        val auth = ApiKeyAuthentication(apiKey, AuthorityUtils.NO_AUTHORITIES)
        return auth
    }
}