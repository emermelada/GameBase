package com.example.gamebase.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.gamebase.R

@Composable
fun SignUpScreen(){
    var email by remember { mutableStateOf<String>("") }
    var username by remember { mutableStateOf<String>("") }
    var password by remember { mutableStateOf<String>("") }
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(text = stringResource(R.string.emailSignUp))
        TextField(
            value = email,
            onValueChange = { email = it}
        )
        Text(text = stringResource(R.string.usernameSignUp))
        TextField(
            value = username,
            onValueChange = { username = it}
        )
        Text(text = stringResource(R.string.passwordSignUp))
        TextField(
            value = password,
            onValueChange = { password = it}
        )
    }
}