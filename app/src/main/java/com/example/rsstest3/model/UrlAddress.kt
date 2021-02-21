package com.example.rsstest3.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "UrlAddress")
data class UrlAddress(

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    val id: Int? = null,

    // Value from API
    @ColumnInfo(name = "urlAddres")
    var urlAddres: String

    )