package com.example.redditapp.service.model.appmodel

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize()
data class RedditModel (

    var author: String = "",
    var title: String = "",
    var id: String = "",
    var thumbnailHeight: Int = 0,
    var thumbnailWidth: Int = 0,
    var thumbnail: String = "",
    var url: String = "",
    var urlOver: String = "",
    var score: Int = 0,
    var numComments: Int = 0,

    ) : Parcelable
