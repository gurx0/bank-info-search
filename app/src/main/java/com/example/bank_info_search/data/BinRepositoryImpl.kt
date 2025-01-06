package com.example.bank_info_search.data

import android.util.Log
import com.example.bank_info_search.data.models.BinResponse
import com.example.bank_info_search.data.models.HistoryItem
import com.example.bank_info_search.domain.BankInfo
import com.example.bank_info_search.domain.BinDomainModel
import com.example.bank_info_search.domain.BinRepository
import com.example.bank_info_search.domain.CountryInfo
import com.example.bank_info_search.domain.NumberInfo
import com.example.bank_info_search.domain.network.ApiService
import kotlinx.coroutines.delay

class BinRepositoryImpl(
    private val apiService: ApiService,
    private val historyDao: HistoryDao
) : BinRepository {
    override suspend fun getBinDetails(bin: String): BinDomainModel {
        var retryCount = 0
        val maxRetryAttempts = 3
        val delayTimeMillis = 5000L

        while (true) {
            try {
                val response = apiService.getBinDetails(bin)
                Log.d("request","${response}")
                historyDao.insertHistory(HistoryItem(bin = bin, data = response))
                return response.toDomainModel()
            } catch (e: retrofit2.HttpException) {
                //слишком много запросов
                if (e.code() == 429 && retryCount < maxRetryAttempts) {
                    retryCount++
                    delay(delayTimeMillis)
                } else {
                    throw e
                }
            }
        }
    }


    override suspend fun getHistory(): List<BinDomainModel> {
        return historyDao.getAllHistory().map { historyItem ->
            historyItem.data.toDomainModel()
        }
    }

    private fun BinResponse.toDomainModel(): BinDomainModel {
        return BinDomainModel(
            number = this.number?.let {
                NumberInfo(
                    length = this.number.length,
                    luhn = this.number.luhn,
                )
            },
            scheme = this.scheme,
            type = this.type,
            brand = this.brand,
            prepaid = this.prepaid,
            country = this.country?.let {
                CountryInfo(
                    numeric = it.numeric,
                    alpha2 = it.alpha2,
                    name = it.name,
                    emoji = it.emoji,
                    currency = it.currency,
                    latitude = it.latitude,
                    longitude = it.longitude,
                )
            },
            bank = this.bank?.let {
                BankInfo(
                    name = it.name,
                    url = it.url,
                    phone = it.phone,
                    city = it.city
                )
            }
        )
    }
}