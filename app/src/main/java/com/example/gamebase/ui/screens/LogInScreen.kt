package com.example.gamebase.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.example.gamebase.R
import com.example.gamebase.ui.components.GameBaseHeader
import com.example.gamebase.ui.components.RegisterLogInField

@Composable
fun LogInScreen(onClickLogIn: (String, String)-> Unit, onClickGoToSignUp: ()-> Unit){
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column{
        GameBaseHeader()
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Card(
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 9.dp)
            ){
                RegisterLogInField(R.string.emailSignUp, email) { it: String -> email = it }
                RegisterLogInField(R.string.passwordSignUp, password) { it: String -> password = it }
            }
            Button(
                modifier = Modifier
                    .padding(8.dp),
                onClick = {
                    onClickLogIn(email, password)
                }
            ) {
                Text(text = stringResource(R.string.logInButton))
            }
            Text(
                text = stringResource(R.string.noAccountMessage),
                modifier = Modifier.clickable {onClickGoToSignUp() },
                textDecoration = TextDecoration.Underline
            )
        }
    }
}