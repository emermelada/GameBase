package com.example.gamebase.ui.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.gamebase.data.model.Game

class GameListViewModel: ViewModel() {
    var games by mutableStateOf(listOf<Game>())
        private set

    fun replaceGames (games:List<Game>){
        this.games = games
    }
}