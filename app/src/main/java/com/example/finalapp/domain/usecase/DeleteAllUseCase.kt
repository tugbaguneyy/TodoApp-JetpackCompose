package com.example.finalapp.domain.usecase

import com.example.finalapp.domain.repository.TodoDaoRepositoryImpl
import javax.inject.Inject

class DeleteAllUseCase @Inject constructor(
    private val repository: TodoDaoRepositoryImpl)
{
    suspend operator fun invoke() {
        repository.deleteAllTodos()
    }
}