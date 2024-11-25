package com.example.gamebase.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.gamebase.ui.components.MainScaffold
import com.example.gamebase.ui.viewmodels.GameListViewModel
import com.google.firebase.auth.FirebaseAuth

class HomeAppActivity: ComponentActivity() {
    private lateinit var auth: FirebaseAuth
    private val gameListViewModel: GameListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inicializar Firebase Auth
        auth = FirebaseAuth.getInstance()

        setContent {
            MainScaffold(gameListViewModel)
        }
    }
}