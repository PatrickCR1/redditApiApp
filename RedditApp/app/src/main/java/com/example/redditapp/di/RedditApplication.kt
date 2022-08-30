package com.example.redditapp.di

import android.app.Application
import com.example.redditapp.di.modules.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class RedditApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@RedditApplication)
            modules(
                listOf(
                    redditDatabaseModules,
                    redditWebClientModules,
                    redditRepositoryModules,
                    redditViewModelModules,
                    redditAdapterModules
                )
            )
        }
    }
}
