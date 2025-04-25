package com.example.finalapp.presentation.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalapp.data.local.TodoEntitiy
import com.example.finalapp.domain.usecase.TodoUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailScreenViewModel @Inject constructor(
    private val todoUseCases: TodoUseCases,
    savedStateHandle: SavedStateHandle
) : ViewModel(){
    val id =savedStateHandle.get<Int>("id") ?: 0
    private val _todo= MutableStateFlow<TodoEntitiy>(TodoEntitiy(title = "Boş veri", description = "Boş veri"))
    val todo : MutableStateFlow<TodoEntitiy> get() =_todo

    init {
        getById(id)
    }

    private fun getById(id : Int){
        viewModelScope.launch {
            todoUseCases.getTodoById(id).collect{data ->
                _todo.value=data
            }
        }
    }
}