package com.example.redditapp.service.model.APIModel

import com.example.redditapp.service.model.APIModel.Post
import com.google.gson.annotations.SerializedName

data class PostList(
    @SerializedName("children")
    var postList: List<Post> = arrayListOf(),

    @SerializedName("after")
    var after: String = ""
)
