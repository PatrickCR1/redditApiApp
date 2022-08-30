package com.example.redditapp.service.model.databasemodel

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "Reddit")
data class RedditDatabaseModel (

    @SerializedName("author")
    @ColumnInfo(name = "author")
    var author: String = "",

    @SerializedName("title")
    @ColumnInfo(name = "title")
    var title: String = "",

    @SerializedName("id")
    @ColumnInfo(name = "id")
    @PrimaryKey
    var id: String = "",

    @SerializedName("thumbnail_height")
    var thumbnailHeight: Int = 0,

    @SerializedName("thumbnail_width")
    var thumbnailWidth: Int = 0,

    @SerializedName("thumbnail")
    @ColumnInfo(name = "thumbnail")
    var thumbnail: String = "",

    @SerializedName("url")
    @ColumnInfo(name = "url")
    var url: String = "",

    @SerializedName("url_overridden_by_dest")
    @ColumnInfo(name = "url_overridden_by_dest")
    var urlOver: String = "",

    @SerializedName("score")
    @ColumnInfo(name = "score")
    var score: Int = 0,

    @SerializedName("num_comments")
    @ColumnInfo(name = "num_comments")
    var numComments: Int = 0,

    )
