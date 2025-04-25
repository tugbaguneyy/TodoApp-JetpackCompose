package com.example.finalapp.domain.usecase

import com.example.finalapp.data.local.TodoEntitiy
import com.example.finalapp.domain.repository.TodoDaoRepositoryImpl
import javax.inject.Inject

class DeleteTodoUseCase @Inject constructor(
    private val repository: TodoDaoRepositoryImpl
) {
    suspend operator fun invoke(id: Int) {
        repository.deleteTodo(id)
    }
}
