package com.example.gamebase.data.repositories

import com.example.gamebase.data.model.ApiResponse
import com.example.gamebase.data.model.Game
import com.example.gamebase.data.remote.RetroFitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GameRepository {

    suspend fun fetchGames(): ApiResponse? {
        return try {
            // Call the suspend function directly
            val response = RetroFitInstance.apiRawgGamesService.getGames("b3a979b2b42e43b1a922a6734076fb1b")
            response
        } catch (e: Exception) {
            // Log or handle the error
            null
        }
    }

    suspend fun fetchGamesPagination(url: String?): ApiResponse? {
        return withContext(Dispatchers.IO){
            // Use Retrofit to fetch data from the provided URL
            if (url != null) {
                RetroFitInstance.apiRawgGamesService.getGamesFromUrl(url)
            } else {
                null
            }
        }
    }


}