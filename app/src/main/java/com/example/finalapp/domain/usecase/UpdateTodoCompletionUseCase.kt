package com.example.finalapp.domain.usecase

import com.example.finalapp.domain.repository.TodoDaoRepositoryImpl
import javax.inject.Inject

class UpdateTodoCompletionUseCase @Inject constructor(
    private val repository: TodoDaoRepositoryImpl
){
    suspend operator fun invoke(id: Int, isCompleted: Boolean) {
        repository.updateTodoCompletion(id, isCompleted)
    }

}