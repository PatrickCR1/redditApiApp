package com.example.redditapp.service.repository.remote

import com.example.redditapp.service.model.APIModel.TopResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RedditService {

    @GET("top.json")
    fun getReddits(): Call<TopResponse>

    @GET("top.json")
    fun getMoreReddits(@Query("after") after: String): Call<TopResponse>

}