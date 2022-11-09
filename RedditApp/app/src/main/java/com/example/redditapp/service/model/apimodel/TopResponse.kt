package com.example.redditapp.service.model.apimodel

import com.google.gson.annotations.SerializedName

data class TopResponse(
    @SerializedName("data")
    var data: PostList = PostList()
)
