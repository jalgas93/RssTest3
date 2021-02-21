package com.example.rsstest3.repository

import com.example.rsstest3.Base_Application
import com.example.rsstest3.model.UrlAddress

//import com.example.rsstest3.cache.RoomDao

class Repository() {

//     suspend fun insertUrl( channel: Channel) =
//        Base_Application.getDatabase().getRoomDao().insertUrl(channel)

//    suspend fun getUrl() = Base_Application.getDatabase().getRoomDao().getUrl()

//    suspend fun deleteItem(channel:Channel) =
//        Base_Application.getDatabase().getRoomDao().delete(channel)


    suspend fun insertUrlAddress( urlAddress: UrlAddress) =
        Base_Application.getDatabase().getRoomDao().insertUrlAddress(urlAddress)

    suspend fun getUrlAddress() = Base_Application.getDatabase().getRoomDao().getUrlAddress()

}