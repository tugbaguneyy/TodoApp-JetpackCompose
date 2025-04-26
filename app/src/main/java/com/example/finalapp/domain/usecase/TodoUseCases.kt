package com.example.finalapp.domain.usecase

import javax.inject.Inject

data class TodoUseCases @Inject constructor(
    val getTodos: GetTodosUseCase,
    val getTodoById: GetTodoByIdUseCase,
    val addTodo: AddTodoUseCase,
    val deleteTodo: DeleteTodoUseCase,
    val updateTodoCompletion: UpdateTodoCompletionUseCase,
    val updateTodo: UpdateTodoUseCase

)