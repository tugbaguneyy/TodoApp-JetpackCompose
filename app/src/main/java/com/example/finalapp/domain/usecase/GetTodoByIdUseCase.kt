package com.example.finalapp.domain.usecase

import com.example.finalapp.data.local.TodoEntitiy
import com.example.finalapp.domain.repository.TodoDaoRepositoryImpl
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTodoByIdUseCase @Inject constructor(
    private val repository: TodoDaoRepositoryImpl
) {
    operator fun invoke(id: Int): Flow<TodoEntitiy> {
        return repository.getTodoById(id)
    }
}