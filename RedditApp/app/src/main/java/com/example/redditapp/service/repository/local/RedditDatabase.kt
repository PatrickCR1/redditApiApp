package com.example.redditapp.service.repository.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.redditapp.service.constants.RedditConstants
import com.example.redditapp.service.model.databasemodel.RedditDatabaseModel

@Database(entities = [RedditDatabaseModel::class], version = 1)
abstract class RedditDatabase: RoomDatabase() {

    abstract val redditDAO: RedditDAO

    // Singleton
    companion object {
        private lateinit var INSTANCE: RedditDatabase

        fun getDatabase(context: Context): RedditDatabase {
            if (!Companion::INSTANCE.isInitialized) {
                synchronized(RedditDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context, RedditDatabase::class.java, RedditConstants.BUILDER.DB_NAME)
                        .allowMainThreadQueries()
                        .build()
                }
            }
            return INSTANCE
        }
    }
}
