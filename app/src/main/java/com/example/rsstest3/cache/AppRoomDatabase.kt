package com.example.rsstest3.cache

import androidx.room.*
import com.example.rsstest3.model.Channel
import com.example.rsstest3.model.Image

@Database(entities = [Channel::class,Image::class], version = 2)
abstract class AppRoomDatabase : RoomDatabase() {
    abstract fun getRoomDao(): RoomDao
}