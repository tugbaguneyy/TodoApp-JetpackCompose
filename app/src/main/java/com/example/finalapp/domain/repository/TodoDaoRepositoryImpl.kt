package com.example.finalapp.domain.repository

import com.example.finalapp.data.local.TodoDao
import com.example.finalapp.data.local.TodoEntitiy
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class TodoDaoRepositoryImpl @Inject constructor(
    private val todoDao: TodoDao
){

    suspend fun insertTodo(todo: TodoEntitiy) {
        todoDao.insertTodo(todo)
    }

    fun getTodos() : Flow<List<TodoEntitiy>> = flow{
        todoDao.getTodos().collect{
            emit(it)
        }
    }
    suspend fun deleteTodo(id: Int) {
        todoDao.deleteTodo(id)
    }

    fun getTodoById(id: Int): Flow<TodoEntitiy> = flow{
        todoDao.getTodoById(id).collect{
            emit(it)
        }
    }

    suspend fun updateTodoCompletion(id: Int, isCompleted: Boolean) {
        todoDao.updateTodoCompletion(id, isCompleted)
    }

    suspend fun updateTodo(id: Int, title: String, description: String, isCompleted: Boolean) {
        todoDao.updateTodo(id, title, description, isCompleted)
    }


}