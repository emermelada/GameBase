package com.example.gamebase.data.model

data class Game (
    val id: Int,
    val name: String,
    val background_image: String,
    val rating: Double,
    val rating_top: Double,
    val metacritic: Double,
    val playtime: Double
)
