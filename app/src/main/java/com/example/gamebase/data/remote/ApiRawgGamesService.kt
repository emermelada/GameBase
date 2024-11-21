package com.example.gamebase.data.remote

import com.example.gamebase.data.model.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface ApiRawgGamesService {
    @GET("games")
    suspend fun getGames(@Query("key") apiKey: String): ApiResponse

    @GET
    suspend fun getGamesFromUrl(@Url url: String): ApiResponse
}