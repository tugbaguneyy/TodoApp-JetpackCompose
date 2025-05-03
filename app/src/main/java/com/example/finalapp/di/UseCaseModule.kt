package com.example.finalapp.di

import com.example.finalapp.domain.repository.TodoDaoRepositoryImpl
import com.example.finalapp.domain.usecase.AddTodoUseCase
import com.example.finalapp.domain.usecase.DeleteAllUseCase
import com.example.finalapp.domain.usecase.DeleteTodoUseCase
import com.example.finalapp.domain.usecase.GetTodoByIdUseCase
import com.example.finalapp.domain.usecase.GetTodosUseCase
import com.example.finalapp.domain.usecase.UpdateTodoCompletionUseCase
import com.example.finalapp.domain.usecase.UpdateTodoUseCase
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
    fun provideGetTodosUseCase(repository: TodoDaoRepositoryImpl): GetTodosUseCase {
        return GetTodosUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetTodoByIdUseCase(repository: TodoDaoRepositoryImpl): GetTodoByIdUseCase {
        return GetTodoByIdUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideAddTodoUseCase(repository: TodoDaoRepositoryImpl): AddTodoUseCase {
        return AddTodoUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideDeleteTodoUseCase(repository: TodoDaoRepositoryImpl): DeleteTodoUseCase {
        return DeleteTodoUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideUpdateTodoUseCase(repository: TodoDaoRepositoryImpl): UpdateTodoUseCase {
        return UpdateTodoUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideUpdateTodoCompletionUseCase(repository: TodoDaoRepositoryImpl): UpdateTodoCompletionUseCase {
        return UpdateTodoCompletionUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideDeleteAllTodosUseCase(repository: TodoDaoRepositoryImpl): DeleteAllUseCase {
        return DeleteAllUseCase(repository)
    }
}
