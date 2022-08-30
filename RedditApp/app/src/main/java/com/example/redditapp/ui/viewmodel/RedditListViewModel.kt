package com.example.redditapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.redditapp.service.listener.APIListener
import com.example.redditapp.service.model.appmodel.RedditModel
import com.example.redditapp.service.repository.RedditRepository

class RedditListViewModel(private val repository: RedditRepository): ViewModel() {

    // LiveData
    private val _reddits = MutableLiveData<List<RedditModel?>>()
    val reddits: LiveData<List<RedditModel?>> = _reddits

    private val _clickReddit = MutableLiveData<RedditModel>()
    val clickReddit: LiveData<RedditModel> = _clickReddit

    private val _load = MutableLiveData<Boolean>()
    val load: LiveData<Boolean> = _load

    val list = arrayListOf<RedditModel?>()

    // API Listener
    val listener = object : APIListener<List<RedditModel?>> {
        override fun onSucess(result: List<RedditModel?>) {

            for (reddit in list) {
                if (reddit == null) {
                    list.remove(reddit)
                }
            }
            for (reddit in result) {
                if (reddit != null) {
                    list.add(reddit)
                }
            }
            list.add(null)

            _reddits.value = list

        }

        override fun onFailure(message: String) {

        }
    }

    // Get Lists
    fun getReddits() {
        repository.getRedditList(listener)
        if (!repository.isConnectionAvailable()) {
            _reddits.value = repository.offlineList()

        }
    }

    fun getMoreReddits() {
        repository.getMoreReddits(listener)
    }

    // Click Event
    fun navigate(reddit: RedditModel) {
        _clickReddit.value = reddit
    }
    fun onScroll (visibleItemCount: Int, pastVisiblesItems: Int, totalItemCount: Int) {
        if ((visibleItemCount + pastVisiblesItems) >= totalItemCount) {
            _load.value = true
        }

    }
}
