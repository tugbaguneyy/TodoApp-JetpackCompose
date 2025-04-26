package com.example.finalapp.presentation.home.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun AddTodoButton(onClick: () -> Unit) {
    TextButton(onClick = onClick) {
        Text(
            text = "+ Add Todo",
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Gray
        )
    }
}