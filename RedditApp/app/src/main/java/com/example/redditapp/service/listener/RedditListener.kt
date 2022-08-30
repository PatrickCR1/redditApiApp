package com.example.redditapp.service.listener

import com.example.redditapp.service.model.appmodel.RedditModel

interface RedditListener {

    fun onRedditClick(reddit: RedditModel)

}