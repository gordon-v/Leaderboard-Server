package com.gordon.leaderboard

import jakarta.servlet.FilterChain
import jakarta.servlet.ServletRequest
import jakarta.servlet.ServletResponse
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import org.springframework.web.filter.GenericFilterBean
import org.springframework.security.core.context.SecurityContextHolder
import javax.servlet.ServletException
import java.io.IOException
import java.io.PrintWriter

class AuthenticationFilter : GenericFilterBean() {
    @Throws(IOException::class, ServletException::class)
    override fun doFilter(request: ServletRequest, response: ServletResponse, filterChain: FilterChain) {
        try {
            val authentication = AuthenticationService().getAuthentication(request as HttpServletRequest)
            SecurityContextHolder.getContext().authentication = authentication
        } catch (exp: Exception) {
            val httpResponse = response as HttpServletResponse
            httpResponse.status = HttpServletResponse.SC_UNAUTHORIZED
            httpResponse.contentType = "application/json"
            val writer: PrintWriter = httpResponse.writer
            writer.print(exp.message)
            writer.flush()
            writer.close()
            return
        }

        filterChain.doFilter(request, response)
    }
}