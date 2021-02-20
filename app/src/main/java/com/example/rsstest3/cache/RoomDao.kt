package com.example.rsstest3.cache

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.rsstest3.model.Channel
@Dao
interface RoomDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertUrl(channel:Channel)

    @Query("SELECT * FROM entitiyNameDB")
    suspend fun getUrl():List<Channel>



}