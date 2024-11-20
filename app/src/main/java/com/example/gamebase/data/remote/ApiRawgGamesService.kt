package com.example.gamebase.data.remote

import com.example.gamebase.data.model.Game
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiRawgGamesService {
    @GET("games?key={API_KEY}")
    fun getGames(@Path("API_KEY") apikey: String): Call<List<Game>>
}