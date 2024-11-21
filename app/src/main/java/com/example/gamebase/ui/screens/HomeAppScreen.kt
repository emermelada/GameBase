package com.example.gamebase.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.gamebase.data.repositories.GameRepository
import com.example.gamebase.ui.components.games.GameItem
import com.example.gamebase.ui.viewmodels.GameListViewModel

@Composable
fun HomeAppScreen(gameListViewModel: GameListViewModel){
    val gameRepository = GameRepository()
    var isLoading by remember { mutableStateOf(true) }
    LaunchedEffect(Unit) {
        gameRepository.fetchGames()?.let {
            gameListViewModel.replaceGames(it)
        }
        isLoading = false
    }

    if(isLoading){
        CircularProgressIndicator(modifier = Modifier.padding(16.dp))
    }else{
        LazyColumn (modifier = Modifier.padding(16.dp)){
            items(gameListViewModel.games) { game ->
                GameItem(game)
            }
        }
    }
}