package com.example.finalapp.presentation.home.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.finalapp.data.local.TodoEntitiy

@Composable
fun TodoList(
    todos: List<TodoEntitiy>,
    onItemClick: (TodoEntitiy) -> Unit,
    onCheckedChange: (Int, Boolean) -> Unit,
    onAddTodoClick: () -> Unit
) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(todos.size) { index ->
            TodoItem(
                todo = todos[index],
                onCheckedChange = { isChecked ->
                    onCheckedChange(todos[index].id, isChecked)
                },
                onClick = { onItemClick(todos[index]) }
            )
        }
        item { AddTodoButton(onClick = onAddTodoClick) }
    }
}