package com.example.bank_info_search.domain.useCases

import com.example.bank_info_search.domain.BinDomainModel
import com.example.bank_info_search.domain.BinRepository

class GetBinDetailsUseCase(private val repository: BinRepository) {
    suspend operator fun invoke(bin: String): BinDomainModel = repository.getBinDetails(bin)
}

