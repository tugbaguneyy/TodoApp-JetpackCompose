package com.example.finalapp.presentation.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalapp.data.local.TodoEntitiy
import com.example.finalapp.domain.repository.TodoDaoRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddScreenViewModel @Inject constructor(
    private val repository : TodoDaoRepositoryImpl
) : ViewModel(){

    fun insertTodo(todo : TodoEntitiy){
        viewModelScope.launch {
            repository.insertTodo(todo)
        }
    }
}