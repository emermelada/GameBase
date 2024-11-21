package com.example.gamebase.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun RegisterLogInField(idString: Int, value: String, onChangeField: (String)->Unit){
    Text(
        text = stringResource(idString),
        modifier = Modifier
            .padding(10.dp)
    )
    TextField(
        value = value,
        onValueChange = { onChangeField(it)},
        modifier = Modifier
            .padding(8.dp)
    )
}