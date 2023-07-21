package com.example.todo_compose.repository

import com.example.todo_compose.model.Note
import com.example.todo_compose.room.TodoDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TodoRepository
@Inject
constructor(private val todoDao: TodoDao) {
    suspend fun insert(todo: Note) = withContext(Dispatchers.IO){
        todoDao.insert(todo)
    }

    fun getAllTodos(): Flow<List<Note>> = todoDao.getAllTodo()
}