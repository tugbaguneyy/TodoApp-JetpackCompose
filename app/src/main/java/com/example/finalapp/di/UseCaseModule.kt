package com.example.finalapp.di

import com.example.finalapp.domain.repository.TodoDaoRepositoryImpl
import com.example.finalapp.domain.usecase.AddTodoUseCase
import com.example.finalapp.domain.usecase.DeleteTodoUseCase
import com.example.finalapp.domain.usecase.GetTodoByIdUseCase
import com.example.finalapp.domain.usecase.GetTodosUseCase
import com.example.finalapp.domain.usecase.TodoUseCases
import com.example.finalapp.domain.usecase.UpdateTodoCompletionUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideTodoUseCases(repository: TodoDaoRepositoryImpl): TodoUseCases {
        return TodoUseCases(
            getTodos = GetTodosUseCase(repository),
            getTodoById = GetTodoByIdUseCase(repository),
            addTodo = AddTodoUseCase(repository),
            deleteTodo = DeleteTodoUseCase(repository),
            updateTodoCompletion = UpdateTodoCompletionUseCase(repository)
        )
    }
}
