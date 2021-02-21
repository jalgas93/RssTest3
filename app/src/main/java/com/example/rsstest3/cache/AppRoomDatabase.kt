package com.example.rsstest3.cache

import androidx.room.*
import com.example.rsstest3.model.UrlAddress

@Database(entities = [UrlAddress::class], version =1)
abstract class AppRoomDatabase : RoomDatabase() {
    abstract fun getRoomDao(): RoomDao
}