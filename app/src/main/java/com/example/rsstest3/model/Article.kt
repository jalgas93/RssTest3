package com.example.rsstest3.model

import androidx.room.Entity
import java.io.Serializable
@Entity(tableName = "entityArticle")
class Article (
    var guid: String? = null,
    var title: String? = null,
    var author: String? = null,
    var link: String? = null,
    var pubDate: String? = null,
    var description: String? = null,
    var content: String? = null,
    var image: String? = null,
    var audio: String? = null,
    var video: String? = null,
    var sourceName: String? = null,
    var sourceUrl: String? = null,
    private var _categories: MutableList<String> = mutableListOf()
    ):Serializable