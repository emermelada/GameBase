package com.example.gamebase.ui.screens.register

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.unit.dp
import com.example.gamebase.R
import com.example.gamebase.ui.components.gameBaseHeader

@Composable
fun SignUpScreen(){
    var email by remember { mutableStateOf<String>("") }
    var username by remember { mutableStateOf<String>("") }
    var password by remember { mutableStateOf<String>("") }
    Column{
        gameBaseHeader()
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Card(
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 9.dp)
            ){
                Text(
                    text = stringResource(R.string.emailSignUp),
                    modifier = Modifier
                        .padding(10.dp)
                )
                TextField(
                    value = email,
                    onValueChange = { email = it},
                    modifier = Modifier
                        .padding(8.dp)
                )
                Text(
                    text = stringResource(R.string.usernameSignUp),
                    modifier = Modifier
                        .padding(10.dp)
                )
                TextField(
                    value = username,
                    onValueChange = { username = it},
                    modifier = Modifier
                        .padding(8.dp)
                )
                Text(
                    text = stringResource(R.string.passwordSignUp),
                    modifier = Modifier
                        .padding(10.dp)
                )
                TextField(
                    value = password,
                    onValueChange = { password = it},
                    modifier = Modifier
                        .padding(8.dp)
                )
                Text(
                    text = stringResource(R.string.passwordSignUpCheck),
                    modifier = Modifier
                        .padding(10.dp)
                )
                TextField(
                    value = password,
                    onValueChange = { password = it},
                    modifier = Modifier
                        .padding(8.dp)
                )
            }
            Button(
                modifier = Modifier
                    .padding(8.dp),
                onClick = {}
            ) {
                Text(text = stringResource(R.string.signUpButton))
            }
        }
    }
}