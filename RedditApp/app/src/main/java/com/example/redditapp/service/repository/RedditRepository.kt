package com.example.redditapp.service.repository

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import com.example.redditapp.R
import com.example.redditapp.service.constants.RedditConstants
import com.example.redditapp.service.listener.APIListener
import com.example.redditapp.service.model.APIModel.ApiRedditModel
import com.example.redditapp.service.model.APIModel.TopResponse
import com.example.redditapp.service.model.appmodel.RedditModel
import com.example.redditapp.service.model.databasemodel.RedditDatabaseModel
import com.example.redditapp.service.repository.local.RedditDAO
import com.example.redditapp.service.repository.local.RedditDatabase
import com.example.redditapp.service.repository.remote.RedditService
import com.example.redditapp.service.repository.remote.RetrofitClient
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RedditRepository(private val dao: RedditDAO, private val webService: RedditService, private val context: Context) {

    private var after: String = ""

    // Get Lists
    fun getRedditList(listener: APIListener<List<RedditModel?>>) {
        checkInternet(listener)
        if (checkInternet(listener)) {
            val call = webService.getReddits()
            executeCall(call, listener)
        }
    }

    fun getMoreReddits(listener: APIListener<List<RedditModel?>>) {
        checkInternet(listener)
        if (checkInternet(listener)) {
            val call = webService.getMoreReddits(after)
            executeCall(call, listener)
        }
    }

    // Retrofit Call
    fun executeCall(call: Call<TopResponse>, listener: APIListener<List<RedditModel?>>) {
        call.enqueue(object : Callback<TopResponse> {
            override fun onResponse(call: Call<TopResponse>, response: Response<TopResponse>) {
                if (response.code() == RedditConstants.HTTP.SUCCESS) {
                    dao.clear()
                    var redditList = arrayListOf<RedditModel?>()

                    for (reddit in (response.body()?.data?.postList!!)) {
                        val appModel = reddit.apiRedditModel.toRedditModel()
                        redditList.add(appModel)

                        val dbModel = reddit.apiRedditModel.toRedditDatabaseModel()
                        dao.save(dbModel)

                    }

                    after = response.body()?.data?.after ?: ""
                    listener.onSucess(redditList)

                } else {
                    listener.onFailure(failResponse(response.errorBody()!!.string()))
                }
            }

            override fun onFailure(call: Call<TopResponse>, t: Throwable) {
                listener.onFailure(context.getString(R.string.ERROR_UNEXPECTED))
            }
        })
    }

    fun failResponse(str: String): String {
        return Gson().fromJson(str, String::class.java)
    }

    // Offline List
    fun offlineList(): List<RedditModel> {
        val redditList = dao.redditList().map { it.toRedditModel() }
        return redditList
    }

    // Check Internet
    fun isConnectionAvailable(): Boolean {

        var result = false
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val activeNet = cm.activeNetwork ?: return false
            val networkCapabilities = cm.getNetworkCapabilities(activeNet) ?: return false
            result = when {
                networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                else -> false
            }
        } else {
            // Deprecated
            if (cm.activeNetworkInfo != null) {
                result = when (cm.activeNetworkInfo!!.type) {
                    ConnectivityManager.TYPE_WIFI -> true
                    ConnectivityManager.TYPE_MOBILE -> true
                    ConnectivityManager.TYPE_ETHERNET -> true
                    else -> false
                }
            }
        }
        return result
    }

    fun <T> checkInternet(listener: APIListener<T>): Boolean {
        return if (!isConnectionAvailable()) {
            listener.onFailure(context.getString(R.string.OFFLINE_MODE))
            false
        } else true
    }
}
