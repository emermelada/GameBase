package com.example.gamebase.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import com.google.firebase.auth.FirebaseAuth

class HomeAppActivity: ComponentActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inicializar Firebase Auth
        auth = FirebaseAuth.getInstance()

        setContent {
            Text("Hola hola")
        }
    }
}