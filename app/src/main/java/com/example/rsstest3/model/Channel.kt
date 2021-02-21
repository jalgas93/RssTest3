package com.example.rsstest3.model

import androidx.room.*

import java.io.Serializable

@Entity(tableName = "entitiyNameDB")
data class Channel(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    val id: Int? = null,
    @ColumnInfo(name = "title")
    val title: String = "",
    @ColumnInfo(name = "link")
    var link: String?,
    @ColumnInfo(name = "description")
    val description: String? = null,
    @ColumnInfo(name = "image")
    var image: String? = null,
    @ColumnInfo(name = "lastBuildDate")
    val lastBuildDate: String? = null,
    @ColumnInfo(name = "updatePeriod")
    val updatePeriod: String? = null,
    @ColumnInfo(name = "articles")
    val articles: String? = null
) : Serializable