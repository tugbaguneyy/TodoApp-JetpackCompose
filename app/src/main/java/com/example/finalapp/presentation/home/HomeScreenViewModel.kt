package com.example.finalapp.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalapp.data.local.TodoEntitiy
import com.example.finalapp.domain.usecase.AddTodoUseCase
import com.example.finalapp.domain.usecase.DeleteAllUseCase
import com.example.finalapp.domain.usecase.DeleteTodoUseCase
import com.example.finalapp.domain.usecase.GetTodosUseCase
import com.example.finalapp.domain.usecase.UpdateTodoCompletionUseCase
import com.example.finalapp.domain.usecase.UpdateTodoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val getTodosUseCase: GetTodosUseCase,
    private val updateTodoCompletionUseCase: UpdateTodoCompletionUseCase,
    private val deleteTodoUseCase: DeleteTodoUseCase,
    private val updateTodoUseCase: UpdateTodoUseCase,
    private val addTodoUseCase: AddTodoUseCase,
    private val deleteAllUseCase: DeleteAllUseCase
) : ViewModel() {

    private val _list = MutableStateFlow<List<TodoEntitiy>>(emptyList())
    private val list: StateFlow<List<TodoEntitiy>> = _list.asStateFlow()

    private val _progress = MutableStateFlow(0f)
    val progress: StateFlow<Float> = _progress.asStateFlow()

    private val _searchQuery = MutableStateFlow("")
    private val searchQuery = _searchQuery.asStateFlow()

    init {
        getAllTodos()
    }

    private fun getAllTodos() {
        viewModelScope.launch {
            getTodosUseCase().collect { todoList ->
                _list.value = todoList
                calculateProgress(todoList)
            }
        }
    }

    private fun calculateProgress(todoList: List<TodoEntitiy>) {
        val total = todoList.size
        val completed = todoList.count { it.isCompleted }
        _progress.value = if (total == 0) 0f else completed.toFloat() / total.toFloat()
    }

    fun updateTodoCompletion(id: Int, isCompleted: Boolean) {
        viewModelScope.launch {
            updateTodoCompletionUseCase(id, isCompleted)
        }
    }

    fun deleteTodo(id: Int) {
        viewModelScope.launch {
            deleteTodoUseCase(id)
        }
    }

    fun updateTodo(id: Int, title: String, description: String, isCompleted: Boolean) {
        viewModelScope.launch {
            updateTodoUseCase(id, title, description, isCompleted)
        }
    }

    fun insertTodo(todo: TodoEntitiy) {
        viewModelScope.launch {
            addTodoUseCase(todo)
        }
    }

    fun deleteAllTodos() {
        viewModelScope.launch {
            deleteAllUseCase()
        }
    }

    fun onSearchQueryChanged(query: String) {
        _searchQuery.value = query
    }

    val filteredList = combine(list, searchQuery) { todos, query ->
        if (query.isBlank()) {
            todos
        } else {
            todos.filter { it.title.contains(query, ignoreCase = true) }
        }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())
}
