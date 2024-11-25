package com.example.gamebase.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.gamebase.ui.screens.HomeAppScreen
import com.example.gamebase.ui.viewmodels.GameListViewModel

@Composable
fun MainScaffold(gameListViewModel: GameListViewModel) {
    Scaffold(
        bottomBar = {
            BottomAppBar(
                containerColor = Color.White,
                modifier = Modifier.padding(1.dp)
            ){
                Button(onClick = {}) {
                    Text("Hola")
                }
            }
        }
    ){
            innerPadding -> HomeAppScreen(innerPadding, gameListViewModel)
    }
}