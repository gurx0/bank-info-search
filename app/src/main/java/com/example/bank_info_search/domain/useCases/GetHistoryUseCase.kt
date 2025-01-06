package com.example.bank_info_search.domain.useCases

import com.example.bank_info_search.domain.BinDomainModel
import com.example.bank_info_search.domain.BinRepository

class GetHistoryUseCase(private val repository: BinRepository) {
    suspend operator fun invoke(): List<BinDomainModel> = repository.getHistory()
}
