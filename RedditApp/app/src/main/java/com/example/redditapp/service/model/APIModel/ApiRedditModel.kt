package com.example.redditapp.service.model.APIModel

import com.google.gson.annotations.SerializedName

data class ApiRedditModel (

    @SerializedName("author")
    var author: String = "",

    @SerializedName("title")
    var title: String = "",

    @SerializedName("id")
    var id: String = "",

    @SerializedName("thumbnail_height")
    var thumbnailHeight: Int = 0,

    @SerializedName("thumbnail_width")
    var thumbnailWidth: Int = 0,

    @SerializedName("thumbnail")
    var thumbnail: String = "",

    @SerializedName("url")
    var url: String = "",

    @SerializedName("url_overridden_by_dest")
    var urlOver: String = "",

    @SerializedName("score")
    var score: Int = 0,

    @SerializedName("num_comments")
    var numComments: Int = 0,

    )
