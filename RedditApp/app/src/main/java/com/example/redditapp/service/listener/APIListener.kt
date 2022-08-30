package com.example.redditapp.service.listener

interface APIListener<T> {

    fun onSucess(result: T)

    fun onFailure(message: String)

}