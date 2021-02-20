package com.example.rsstest3.repository

import com.example.rsstest3.Base_Application
import com.example.rsstest3.model.Channel

//import com.example.rsstest3.cache.RoomDao

class Repository() {

     suspend fun insertUrl( channel: Channel) =
        Base_Application.getDatabase().getRoomDao().insertUrl(channel)

    suspend fun getUrl() = Base_Application.getDatabase().getRoomDao().getUrl()

}