package com.example.redditapp.service.repository.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.redditapp.service.model.databasemodel.RedditDatabaseModel

@Dao
interface RedditDAO {

    @Insert
    fun save(reddit: RedditDatabaseModel)

    @Query("SELECT * FROM Reddit")
    fun redditList(): List<RedditDatabaseModel>

    @Query("DELETE FROM Reddit")
    fun clear()
}
