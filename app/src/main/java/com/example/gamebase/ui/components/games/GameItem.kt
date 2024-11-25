package com.example.gamebase.ui.components.games

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.gamebase.data.model.Game

@Composable
fun GameItem(game: Game){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column ( modifier = Modifier.padding(8.dp)){
            Text(text = "Name: ${game.name}", style = MaterialTheme.typography.bodyLarge)
            AsyncImage(model = game.background_image, contentDescription = "${game.name} image.")
            Text(text = "Metacritic: ${game.metacritic}", style = MaterialTheme.typography.bodyMedium)
        }
    }
}