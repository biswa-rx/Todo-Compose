package com.example.todo_compose.di

import android.app.Application
import androidx.core.app.RemoteInput.Source
import androidx.room.Room
import com.example.todo_compose.room.TodoDao
import com.example.todo_compose.room.TodoDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RoomModule {

    @Provides
    @Singleton
    fun providesDatabase(application: Application):
            TodoDatabase = Room.databaseBuilder(application,TodoDatabase::class.java,"todoDatabase")
        .fallbackToDestructiveMigration().build()

    @Provides
    @Singleton
    fun provideTodoDao(todoDatabase: TodoDatabase):TodoDao = todoDatabase.getDao()

}