package com.example.finalapp.presentation.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun DetailScreen(){
    val viewModel = hiltViewModel<DetailScreenViewModel>()
    val todo=viewModel.todo.collectAsStateWithLifecycle()

    Column(modifier = Modifier.fillMaxSize()){
        Text(todo.value.title)
        Text(todo.value.description)
        Switch(
            checked = todo.value.isCompleted,
            onCheckedChange = {

            }
        )
    }
}