package com.example.finalapp.presentation.home

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.finalapp.data.local.TodoEntitiy
import com.example.finalapp.presentation.home.components.AddTodoBottomSheet
import com.example.finalapp.presentation.home.components.BottomBar
import com.example.finalapp.presentation.home.components.DateHeader
import com.example.finalapp.presentation.home.components.TodoBottomSheet
import com.example.finalapp.presentation.home.components.TodoList
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeScreen() {
    val viewModel = hiltViewModel<HomeScreenViewModel>()
    val todos = viewModel.list.collectAsStateWithLifecycle()
    val progress = viewModel.progress.collectAsStateWithLifecycle()
    val filteredTodos = viewModel.filteredList.collectAsStateWithLifecycle()
    val dateFormatted = LocalDate.now().format(DateTimeFormatter.ofPattern("dd MMM yyyy"))

    var isSearching by remember { mutableStateOf(false) }
    var searchText by remember { mutableStateOf("") }


    var selectedTodo by remember { mutableStateOf<TodoEntitiy?>(null) }
    var showAddSheet by remember { mutableStateOf(false) }

    Scaffold(
        bottomBar = {
            BottomBar(
                progress = progress.value,
                isSearching = isSearching,
                searchText = searchText,
                onSearchTextChange = { text ->
                    searchText = text
                    viewModel.onSearchQueryChanged(text)
                },
                onAddClick = { showAddSheet = true },
                onSearchClick = {
                    isSearching = !isSearching
                    if (!isSearching) {
                        searchText = ""
                        viewModel.onSearchQueryChanged("")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(modifier = Modifier
            .padding(paddingValues)
            .padding(16.dp)
        ) {

            DateHeader(dateFormatted)

            TodoList(
                todos = filteredTodos.value,
                onItemClick = { selectedTodo = it },
                onCheckedChange = { id, isCompleted ->
                    viewModel.updateTodoCompletion(id, isCompleted)
                },
                onAddTodoClick = { showAddSheet = true }
            )

            selectedTodo?.let { todo ->
                TodoBottomSheet(
                    todo = todo,
                    onDismiss = { selectedTodo = null },
                    onUpdate = { title, desc, completed ->
                        viewModel.updateTodo(todo.id, title, desc, completed)
                    },
                    onDelete = {
                        viewModel.deleteTodo(todo.id)
                    }
                )
            }

            if (showAddSheet) {
                AddTodoBottomSheet(
                    onDismiss = { showAddSheet = false },
                    onInsert = { title, description ->
                        viewModel.insertTodo(
                            TodoEntitiy(
                                title = title,
                                description = description
                            )
                        )
                    }
                )
            }
        }
    }
}
