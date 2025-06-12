package com.kamalnathvg.mobirr.domain_radarr.repository

import io.ktor.client.HttpClient
import io.ktor.client.request.get

interface AuthRepository{
    suspend fun isLoggedIn(): Boolean
    suspend fun login(apiKey: String): Result<Unit>
}


private const val BASE_URL = "http://100.113.11.77:7878"

private const val API_VERSION_3 = "/api/v3"



internal class AuthRepositoryImpl(
    private val httpClient: HttpClient,
){
    suspend fun isLoggedIn(): Boolean{
        val url = "$BASE_URL$API_VERSION_3/login"
        httpClient.get(url)
        return true
    }
}