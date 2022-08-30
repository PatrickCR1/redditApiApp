package com.example.redditapp.service.image

import android.content.Context
import android.widget.ImageView
import com.example.redditapp.ui.view.fragment.CompleteRedditFragment
import com.squareup.picasso.Picasso

class ImageService private constructor() {

    companion object {

        fun loadImage(context: Context, url: String, view: ImageView) {
            Picasso.with(context)
                .load(url)
                .into(view)
        }
    }
}
