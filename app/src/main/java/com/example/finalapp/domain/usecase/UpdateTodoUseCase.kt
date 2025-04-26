package com.example.finalapp.domain.usecase

import com.example.finalapp.domain.repository.TodoDaoRepositoryImpl
import javax.inject.Inject

class UpdateTodoUseCase @Inject constructor(
    private val repository: TodoDaoRepositoryImpl
){
    suspend operator fun invoke(id: Int, title: String, description: String, isCompleted: Boolean) {
        repository.updateTodo(id, title, description, isCompleted)
    }
}