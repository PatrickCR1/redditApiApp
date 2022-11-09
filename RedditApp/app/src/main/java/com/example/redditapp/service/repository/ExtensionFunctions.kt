package com.example.redditapp.service.repository

import com.example.redditapp.service.model.apimodel.ApiRedditModel
import com.example.redditapp.service.model.appmodel.RedditModel
import com.example.redditapp.service.model.databasemodel.RedditDatabaseModel

fun ApiRedditModel.toRedditModel() = RedditModel(
    author = author,
    title = title,
    id = id,
    thumbnailHeight = thumbnailHeight,
    thumbnailWidth = thumbnailWidth,
    thumbnail = thumbnail,
    url = url,
    urlOver = urlOver,
    score = score,
    numComments = numComments
)

fun ApiRedditModel.toRedditDatabaseModel() = RedditDatabaseModel(
    author = author,
    title = title,
    id = id,
    thumbnailHeight = thumbnailHeight,
    thumbnailWidth = thumbnailWidth,
    thumbnail = thumbnail,
    url = url,
    urlOver = urlOver,
    score = score,
    numComments = numComments
)

fun RedditDatabaseModel.toRedditModel() = RedditModel(
    author = author,
    title = title,
    id = id,
    thumbnailHeight = thumbnailHeight,
    thumbnailWidth = thumbnailWidth,
    thumbnail = thumbnail,
    url = url,
    urlOver = urlOver,
    score = score,
    numComments = numComments
)
