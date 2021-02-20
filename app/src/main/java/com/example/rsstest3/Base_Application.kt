package com.example.rsstest3

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.rsstest3.cache.AppRoomDatabase

class Base_Application : Application() {
    override fun onCreate() {
        super.onCreate()
        instance = this

        database = Room.databaseBuilder(this, AppRoomDatabase::class.java, "RssDatabase")
            .build()
    }

    companion object {
        private var instance: Base_Application? = null
        private var database: AppRoomDatabase? = null
        fun getInstance(): Base_Application {
            return instance!!
        }

        fun getDatabase(): AppRoomDatabase {
            return database!!
        }
    }

}