package com.gordon.leaderboard

import org.springframework.security.authentication.AbstractAuthenticationToken
import org.springframework.security.core.GrantedAuthority

class ApiKeyAuthentication(apiKey: String, authorities: MutableCollection<out GrantedAuthority>?) : AbstractAuthenticationToken(
    authorities
) {
    private lateinit var apiKey: String

    fun ApiKeyAuthentication(apiKey: String, authorities: MutableCollection<out GrantedAuthority>?){
        this.apiKey = apiKey
        isAuthenticated = true
    }

    override fun getCredentials() {
        return
    }

    override fun getPrincipal(): Any {
        return apiKey
    }
}