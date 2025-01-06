package com.example.bank_info_search.domain.useCases

import com.example.bank_info_search.data.models.BinDomainModel
import com.example.bank_info_search.data.repo.BinRepository

class GetBinDetailsUseCase(private val repository: BinRepository) {
    suspend operator fun invoke(bin: String): BinDomainModel = repository.getBinDetails(bin)
}

