package com.example.bank_info_search.data.repo

import com.example.bank_info_search.data.models.BinDomainModel
import com.example.bank_info_search.data.models.HistoryItem

interface BinRepository {
    suspend fun getBinDetails(bin: String): BinDomainModel
    suspend fun getHistory(): List<HistoryItem>
}
