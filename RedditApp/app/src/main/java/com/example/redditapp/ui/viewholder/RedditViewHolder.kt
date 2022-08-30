package com.example.redditapp.ui.viewholder


import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.example.redditapp.databinding.RowRedditListBinding
import com.example.redditapp.service.image.ImageService
import com.example.redditapp.service.listener.RedditListener
import com.example.redditapp.service.model.appmodel.RedditModel

class RedditViewHolder(private val itemBinding: RowRedditListBinding, val listener: RedditListener, val context: Context) :
    RecyclerView.ViewHolder(itemBinding.root) {
    fun bindData(reddit: RedditModel?) {
        // Binding
        itemBinding.textTitle.text = reddit?.title
        ImageService.loadImage(context,reddit!!.thumbnail, itemBinding.imageReddit)

        // Events
        itemBinding.imageReddit.setOnClickListener{listener.onRedditClick(reddit!!)}
        itemBinding.textTitle.setOnClickListener{listener.onRedditClick(reddit!!)}

    }
}
