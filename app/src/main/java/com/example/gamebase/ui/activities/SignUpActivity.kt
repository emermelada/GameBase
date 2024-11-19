package com.example.gamebase.ui.activities

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.gamebase.ui.screens.register.SignUpScreen
import com.google.firebase.auth.FirebaseAuth

class SignUpActivity: ComponentActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inicializar Firebase Auth
        auth = FirebaseAuth.getInstance()

        setContent {
            SignUpScreen { email, password ->
                if (email.isNotEmpty() && password.isNotEmpty()) {
                    createAccount(email, password)
                } else {
                    Toast.makeText(
                        this,
                        "Por favor, complete todos los campos.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    private fun createAccount(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    signIn(email, password)
                    finish()
                }
            }
    }

    private fun signIn(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {

                }
            }
    }
}