package com.example.gamebase.data.remote

import com.example.gamebase.data.model.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiRawgGamesService {
    @GET("games")
    suspend fun getGames(@Query("key") apiKey: String): ApiResponse
}