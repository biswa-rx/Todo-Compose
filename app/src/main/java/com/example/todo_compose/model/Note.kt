package com.example.todo_compose.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todoTable")
data class Note(
    val title: String,
    val description:String
){
    @PrimaryKey(autoGenerate = true)
    var id:Int? = null
}
