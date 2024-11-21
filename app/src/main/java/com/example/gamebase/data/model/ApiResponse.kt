package com.example.gamebase.data.model

data class ApiResponse(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<Game>
)