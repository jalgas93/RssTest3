package com.example.rsstest3.cache

import androidx.room.*
import com.example.rsstest3.model.Article
import com.example.rsstest3.model.Channel
import com.example.rsstest3.model.Image
import com.example.rsstest3.util.DateTypeConverter

@Database(entities = [Channel::class,Image::class], version = 2)
@TypeConverters(DateTypeConverter::class)
abstract class AppRoomDatabase : RoomDatabase() {
    abstract fun getRoomDao(): RoomDao
}