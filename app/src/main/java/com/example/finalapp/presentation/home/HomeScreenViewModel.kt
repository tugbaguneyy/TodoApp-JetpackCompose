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

    init {
        getAllTodos()
    }

    fun getAllTodos(){
        viewModelScope.launch {
            todoUseCases.getTodos().collect{todoList ->
                _list.value=todoList
            }
        }
    }

    fun updateTodoCompletion(id: Int, isCompleted: Boolean) {
        viewModelScope.launch {
            todoUseCases.updateTodoCompletion(id, isCompleted)
        }
    }
}