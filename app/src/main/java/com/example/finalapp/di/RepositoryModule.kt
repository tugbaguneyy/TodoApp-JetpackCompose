package com.example.finalapp.di

import com.example.finalapp.data.local.TodoDao
import com.example.finalapp.domain.repository.TodoDaoRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideTodoRepositoryImpl(todoDao: TodoDao): TodoDaoRepositoryImpl {
        return TodoDaoRepositoryImpl(todoDao)
    }
}
