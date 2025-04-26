package com.example.finalapp.presentation.home

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.finalapp.data.local.TodoEntitiy
import com.example.finalapp.navigation.Screen
import com.example.finalapp.presentation.home.components.DateHeader
import com.example.finalapp.presentation.home.components.TodoBottomSheet
import com.example.finalapp.presentation.home.components.TodoList
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeScreen(navController: NavController) {
    val viewModel = hiltViewModel<HomeScreenViewModel>()
    val todos = viewModel.list.collectAsStateWithLifecycle()
    val dateFormatted = LocalDate.now().format(DateTimeFormatter.ofPattern("dd MMM yyyy"))

    var selectedTodo by remember { mutableStateOf<TodoEntitiy?>(null) }
    val scope = rememberCoroutineScope()

    Column(modifier = Modifier.padding(16.dp)) {
        DateHeader(dateFormatted)

        TodoList(
            todos = todos.value,
            onItemClick = { todo -> selectedTodo = todo },
            onCheckedChange = { id, isChecked ->
                viewModel.updateTodoCompletion(id, isChecked)
            },
            onAddTodoClick = { navController.navigate(Screen.Add) }
        )

        selectedTodo?.let { todo ->
            TodoBottomSheet(
                todo = selectedTodo!!,
                onDismiss = { selectedTodo = null },
                onUpdate = { title, desc, completed ->
                    viewModel.updateTodo(selectedTodo!!.id, title, desc, completed)
                },
                onDelete = {
                    viewModel.deleteTodo(selectedTodo!!.id)
                }
            )
        }
    }
}