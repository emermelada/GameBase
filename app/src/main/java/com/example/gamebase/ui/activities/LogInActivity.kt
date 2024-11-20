package com.example.gamebase.ui.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.gamebase.MainActivity
import com.example.gamebase.ui.screens.LogInScreen
import com.google.firebase.auth.FirebaseAuth

class LogInActivity: ComponentActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inicializar Firebase Auth
        auth = FirebaseAuth.getInstance()

        setContent {
            LogInScreen(
                onClickLogIn = { email, password ->
                    if (email.isNotEmpty() && password.isNotEmpty()) {
                        logInAccount(email, password)
                    } else {
                        Toast.makeText(
                            this,
                            "Por favor, complete todos los campos.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                },
                onClickGoToSignUp = {
                    val intent = Intent(this, SignUpActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            )

        }
    }

    private fun logInAccount(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(
                        baseContext,
                        "Authentication failed.",
                        Toast.LENGTH_SHORT,
                    ).show()
                }
            }
    }
}