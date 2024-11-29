package com.example.gamebase

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.gamebase.ui.activities.AppActivity
import com.example.gamebase.ui.activities.LogInActivity
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth


class MainActivity : ComponentActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Initialize Firebase Auth
        auth = Firebase.auth
    }

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        if (currentUser == null) {
            val intent = Intent(this, LogInActivity::class.java)
            startActivity(intent)
            finish()
        }else{
            val intent = Intent(this, AppActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
