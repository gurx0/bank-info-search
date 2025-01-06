package com.example.bank_info_search.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.bank_info_search.data.models.HistoryItem
import com.example.bank_info_search.utils.Converters

@Database(entities = [HistoryItem::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun historyDao(): HistoryDao
}
