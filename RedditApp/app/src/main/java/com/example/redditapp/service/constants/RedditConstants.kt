package com.example.redditapp.service.constants

class RedditConstants private constructor() {

    object HTTP {
        const val SUCCESS = 200
    }

    object RCVIEW {
        const val VIEW_TYPE_LOADING = 0
        const val VIEW_TYPE_ITEM = 1
    }

    object BUILDER {
        const val BASE_URL = "https://www.reddit.com/"
        const val DB_NAME = "redditDB"
    }

}
