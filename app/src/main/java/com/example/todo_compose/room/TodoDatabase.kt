package com.example.todo_compose.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todo_compose.model.Note

@Database(entities = [Note::class],version = 1,exportSchema = false)
abstract class TodoDatabase : RoomDatabase() {
    abstract fun getDao():TodoDao
}