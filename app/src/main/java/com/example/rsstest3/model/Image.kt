package com.example.rsstest3.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "imageEntity")
data class Image(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "title")
    var title: String = "",
    @ColumnInfo(name = "url")
    var url: String = "",
    @ColumnInfo(name = "link")
    var link: String = "",
    @ColumnInfo(name = "description")
    var description: String = ""
) : Serializable