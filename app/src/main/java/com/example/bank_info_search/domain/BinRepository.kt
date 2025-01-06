package com.example.bank_info_search.domain

interface BinRepository {
    suspend fun getBinDetails(bin: String): BinDomainModel
    suspend fun getHistory(): List<BinDomainModel>
}
