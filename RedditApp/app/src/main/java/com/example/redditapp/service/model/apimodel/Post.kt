package com.example.redditapp.service.model.apimodel

import com.google.gson.annotations.SerializedName

data class Post (
    @SerializedName("data")
    var apiRedditModel: ApiRedditModel = ApiRedditModel()
        )
