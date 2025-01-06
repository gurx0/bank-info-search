package com.example.bank_info_search.domain.useCases

import com.example.bank_info_search.data.models.HistoryItem
import com.example.bank_info_search.data.repo.BinRepository

class GetHistoryUseCase(private val repository: BinRepository) {
    suspend operator fun invoke(): List<HistoryItem> = repository.getHistory()
}
