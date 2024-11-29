package com.example.gamebase.ui.screens.homeApp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material.icons.automirrored.rounded.ArrowForward
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.gamebase.data.repositories.GameRepository
import com.example.gamebase.ui.components.games.GameItem
import kotlinx.coroutines.launch

val gameRepository = GameRepository()

@Composable
fun HomeAppScreen(innerPadding: PaddingValues, gameListViewModel: GameListViewModel){
    var isLoading by remember { mutableStateOf(true) }
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        if(gameListViewModel.isFirstLoad){
            gameRepository.fetchGames()?.let {
                gameListViewModel.replaceGames(it.results)
                gameListViewModel.replaceNextPage(it.next)
                gameListViewModel.replacePreviousPage(it.previous)
            }
            gameListViewModel.changeIsFirstLoad()
        }
        isLoading = false
    }

    if(isLoading){
        Column(
            modifier = Modifier.padding(innerPadding)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
            ){
            CircularProgressIndicator(modifier = Modifier.padding(16.dp))
        }
    }else{
        Column(
            modifier = Modifier.padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            LazyColumn (modifier = Modifier.weight(1f)) {
                items(gameListViewModel.games) { game ->
                    GameItem(game)
                }
            }
            Row ( modifier = Modifier.padding(0.dp)){
                IconButton(
                    onClick = {
                        coroutineScope.launch {
                            fetchGamesUrl(gameListViewModel, gameListViewModel.previousPage)
                        }},
                    enabled = gameListViewModel.previousPage != null,
                    content = {(Icon(Icons.AutoMirrored.Rounded.ArrowBack, contentDescription = "Pagination -1"))}
                )
                IconButton(
                    onClick = {
                        coroutineScope.launch {
                            fetchGamesUrl(gameListViewModel, gameListViewModel.nextPage)
                        }},
                    enabled = gameListViewModel.nextPage != null,
                    content = {(Icon(Icons.AutoMirrored.Rounded.ArrowForward, contentDescription = "Pagination +1"))}
                )
            }
        }
    }
}

suspend fun fetchGamesUrl(gameListViewModel: GameListViewModel, url: String?) {
    gameRepository.fetchGamesPagination(url)?.let { result ->
        gameListViewModel.replaceGames(result.results)
        gameListViewModel.replaceNextPage(result.next)
        gameListViewModel.replacePreviousPage(result.previous)
    }
}
