package com.example.finalapp.presentation.add

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.finalapp.data.local.TodoEntitiy

@Composable
fun AddScreen(){
    val viewModel = hiltViewModel<AddScreenViewModel>()
    val title = remember { mutableStateOf("") }
    val description = remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center)  {
        TextField(value = title.value, onValueChange = {title.value = it})

        Spacer(Modifier.height(30.dp))

        Button(onClick = {
            val todo=TodoEntitiy(title=title.value, description = description.value)
            viewModel.insertTodo(todo)
        }) {
            Text("Add")
        }
    }
}