package com.example.bank_info_search.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bank_info_search.data.models.BinDomainModel
import com.example.bank_info_search.domain.useCases.GetBinDetailsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(private val getBinDetailsUseCase: GetBinDetailsUseCase) : ViewModel() {
    private val _uiState = MutableStateFlow(MainUiState())
    val uiState: StateFlow<MainUiState> = _uiState

    fun onBinInputChange(input: String) {
        _uiState.value = _uiState.value.copy(binInput = input)
    }

    fun fetchBinDetails() = viewModelScope.launch {
        try {
            val details = getBinDetailsUseCase(uiState.value.binInput)
            _uiState.value = _uiState.value.copy(binDetails = details)
        } catch (_: Exception){
        }
    }
}

data class MainUiState(
    val binInput: String = "",
    val binDetails: BinDomainModel? = null
)
