package com.example.redditapp.service.model.APIModel

import com.example.redditapp.service.model.APIModel.PostList
import com.google.gson.annotations.SerializedName

data class TopResponse(
    @SerializedName("data")
    var data: PostList = PostList()
)
