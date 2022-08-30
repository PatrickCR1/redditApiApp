package com.example.redditapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.redditapp.databinding.RowLoadingBinding
import com.example.redditapp.databinding.RowRedditListBinding
import com.example.redditapp.service.constants.RedditConstants
import com.example.redditapp.service.listener.RedditListener
import com.example.redditapp.service.model.appmodel.RedditModel
import com.example.redditapp.ui.viewholder.LoadingViewHolder
import com.example.redditapp.ui.viewholder.RedditViewHolder

class RedditAdapter(private val context: Context) : RecyclerView.Adapter<ViewHolder>() {

    private var listReddits: List<RedditModel?> = arrayListOf()
    private lateinit var redditListener: RedditListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        if (viewType == RedditConstants.RCVIEW.VIEW_TYPE_ITEM) {
            val inflater = LayoutInflater.from(parent.context)
            val itemBinding = RowRedditListBinding.inflate(inflater, parent, false)
            return RedditViewHolder(itemBinding, redditListener, context)
        } else {
            val inflater = LayoutInflater.from(parent.context)
            val itemBinding = RowLoadingBinding.inflate(inflater, parent, false)
            return LoadingViewHolder(itemBinding, context)
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (holder) {
            is RedditViewHolder -> holder.bindData(listReddits[position])
            is LoadingViewHolder -> holder.bindData()
        }

    }

    override fun getItemCount(): Int {
        return listReddits.count()
    }

    override fun getItemViewType(position: Int): Int {
        return if (listReddits[position] == null) {
            RedditConstants.RCVIEW.VIEW_TYPE_LOADING
        } else {
            return RedditConstants.RCVIEW.VIEW_TYPE_ITEM
        }
    }

    fun updateReddits(list: List<RedditModel?>) {
        listReddits = list
        notifyDataSetChanged()

    }

    fun attachRedditListener(listener: RedditListener) {
        redditListener = listener
    }

}
