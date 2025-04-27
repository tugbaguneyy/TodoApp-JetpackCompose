package com.example.finalapp.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalapp.data.local.TodoEntitiy
import com.example.finalapp.domain.repository.TodoDaoRepositoryImpl
import com.example.finalapp.domain.usecase.TodoUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val todoUseCases: TodoUseCases
) : ViewModel(){

    private val _list = MutableStateFlow<List<TodoEntitiy>>(emptyList())
    val list : StateFlow<List<TodoEntitiy>>
        get() = _list.asStateFlow()

    // Progress
    private val _progress = MutableStateFlow(0f) // 0.0 - 1.0
    val progress: StateFlow<Float>
        get() = _progress.asStateFlow()

    init {
        getAllTodos()
    }

    fun getAllTodos() {
        viewModelScope.launch {
            todoUseCases.getTodos().collect { todoList ->
                _list.value = todoList
                calculateProgress(todoList)
            }
        }
    }

    // Progress hesaplayan fonksiyon
    private fun calculateProgress(todoList: List<TodoEntitiy>) {
        val total = todoList.size
        val completed = todoList.count { it.isCompleted }

        _progress.value = if (total == 0) 0f else completed.toFloat() / total.toFloat()
    }

    fun updateTodoCompletion(id: Int, isCompleted: Boolean) {
        viewModelScope.launch {
            todoUseCases.updateTodoCompletion(id, isCompleted)
        }
    }

    fun deleteTodo(id: Int) {
        viewModelScope.launch {
            todoUseCases.deleteTodo(id)
        }
    }

    fun updateTodo(id: Int, title: String, description: String, isCompleted: Boolean) {
        viewModelScope.launch {
            todoUseCases.updateTodo(id, title, description, isCompleted)
        }
    }

    fun insertTodo(todo: TodoEntitiy) {
        viewModelScope.launch {
            todoUseCases.addTodo(todo)
        }

    }
}