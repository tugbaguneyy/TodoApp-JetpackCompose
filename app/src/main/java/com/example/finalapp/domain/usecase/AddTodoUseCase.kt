package com.example.finalapp.domain.usecase

import com.example.finalapp.data.local.TodoEntitiy
import com.example.finalapp.domain.repository.TodoDaoRepositoryImpl
import javax.inject.Inject

class AddTodoUseCase @Inject constructor(
    private val repository: TodoDaoRepositoryImpl
) {
    suspend operator fun invoke(todo: TodoEntitiy) {
        repository.insertTodo(todo)
    }
}
