package com.example.finalapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao{
    @Insert
    suspend fun insertTodo(todo: TodoEntitiy)

    @Query("SELECT * FROM Todos")
    fun getTodos() : Flow<List<TodoEntitiy>>

    @Query("DELETE FROM Todos WHERE id = :id")
    suspend fun deleteTodo(id: Int)

    @Query("SELECT * FROM Todos WHERE id = :id")
    fun getTodoById(id: Int): Flow<TodoEntitiy>

    @Query("UPDATE Todos SET isCompleted = :isCompleted WHERE id = :id")
    suspend fun updateTodoCompletion(id: Int, isCompleted: Boolean)

    @Query("UPDATE Todos SET title = :title, description = :description, isCompleted = :isCompleted WHERE id = :id")
    suspend fun updateTodo(id: Int, title: String, description: String, isCompleted: Boolean)

    @Query("DELETE FROM Todos")
    suspend fun deleteAllTodos()

}