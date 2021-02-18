package com.example.rsstest3.cache

import androidx.room.Dao
import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.rsstest3.model.Channel

@Database(entities = [Channel::class],version = 1)
abstract class AppRoomDatabase :RoomDatabase() {
abstract fun getRoomDao():RoomDao
}