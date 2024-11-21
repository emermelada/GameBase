package com.example.gamebase.data.remote

import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
object RetroFitInstance {
    private const val RAWG_GAMES_URL =  "https://api.rawg.io/api/"

    val apiRawgGamesService: ApiRawgGamesService by lazy {
        Retrofit.Builder()
            .baseUrl(RAWG_GAMES_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiRawgGamesService::class.java)
    }
}