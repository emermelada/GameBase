package com.example.gamebase.ui.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.gamebase.ui.screens.HomeAppScreen
import com.example.gamebase.ui.viewmodels.GameListViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScaffold(gameListViewModel: GameListViewModel) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                modifier = Modifier
                    .height(40.dp),
                title = {
                    Text("GameBase")
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = Color.White,
                modifier = Modifier
                    .padding(0.dp)
                    .height(50.dp)
            ){
                Button(onClick = {},
                    modifier = Modifier.padding(0.dp)) {
                    Text("Hola")
                }
            }
        }
    ){
            innerPadding -> HomeAppScreen(innerPadding, gameListViewModel)
    }
}