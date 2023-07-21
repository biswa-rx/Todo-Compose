package com.example.todo_compose.view

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todo_compose.model.Note
import com.example.todo_compose.repository.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel
@Inject
    constructor(private val repository: TodoRepository)
    : ViewModel() {

    val response:MutableState<List<Note>> = mutableStateOf(listOf())

    fun insert(todo:Note) = viewModelScope.launch {
        repository.insert(todo)
    }
    init {
        getAllTodos()
    }

    fun getAllTodos() = viewModelScope.launch {
        repository.getAllTodos()
            .catch { e->
                Log.d("main", "Exception: ${e.message} ")
            }.collect {
                response.value = it
            }
    }


}