package com.example.gamebase

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.gamebase.ui.screens.register.SignUpScreen
import com.example.gamebase.ui.theme.GameBaseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GameBaseTheme {
                SignUpScreen()
            }
        }
    }
}