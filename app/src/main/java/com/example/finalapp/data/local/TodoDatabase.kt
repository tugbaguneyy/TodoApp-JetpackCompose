package com.example.finalapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [TodoEntitiy::class], version = 2)
abstract class TodoDatabase : RoomDatabase() {

    abstract fun todoDao() : TodoDao

}