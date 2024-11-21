package com.example.gamebase.data.repositories

import com.example.gamebase.data.model.Game
import com.example.gamebase.data.remote.RetroFitInstance

class GameRepository {

    suspend fun fetchGames(): List<Game>? {
        return try {
            // Call the suspend function directly
            val response = RetroFitInstance.apiRawgGamesService.getGames("b3a979b2b42e43b1a922a6734076fb1b")
            response.results // Assuming the `ApiResponse` class has a `results` property
        } catch (e: Exception) {
            // Log or handle the error
            null
        }
    }


}