package com.example.redditapp.service.repository.remote

import com.example.redditapp.service.constants.RedditConstants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient private constructor() {

    companion object {
        fun getHttpClientInstance(): OkHttpClient {
            return OkHttpClient.Builder()
                .build()
        }

        fun getRetrofitInstance(httpClient: OkHttpClient): Retrofit {

            return synchronized(RetrofitClient::class) {
                Retrofit.Builder()
                    .baseUrl(RedditConstants.BUILDER.BASE_URL)
                    .client(httpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
        }
    }
}
