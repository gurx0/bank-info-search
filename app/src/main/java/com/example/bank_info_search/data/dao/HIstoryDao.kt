package com.example.bank_info_search.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.bank_info_search.data.models.HistoryItem

@Dao
interface HistoryDao {
    @Query("SELECT * FROM history")
    suspend fun getAllHistory(): List<HistoryItem>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHistory(item: HistoryItem)
}


