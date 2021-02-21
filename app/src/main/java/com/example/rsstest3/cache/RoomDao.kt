package com.example.rsstest3.cache

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.rsstest3.model.Article
import com.example.rsstest3.model.Channel
import com.example.rsstest3.model.UrlAddress

@Dao
interface RoomDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertUrl(channel:Channel)
//
//    @Query("SELECT * FROM entitiyNameDB")
//    suspend fun getUrl():List<Channel>

    @Delete
    suspend fun delete(channel:Channel)


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertUrlAddress(urlAddress: UrlAddress)

    @Query("SELECT * FROM entitiyNameDB")
    suspend fun getUrlAddress():UrlAddress

}