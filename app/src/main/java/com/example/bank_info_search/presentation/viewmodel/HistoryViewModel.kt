package com.example.bank_info_search.presentation.viewmodel

import com.example.bank_info_search.domain.useCases.GetHistoryUseCase
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bank_info_search.domain.BinDomainModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HistoryViewModel(
    private val getHistoryUseCase: GetHistoryUseCase
) : ViewModel() {

    // список истории
    private val _history = MutableStateFlow<List<BinDomainModel>>(emptyList())
    val history: StateFlow<List<BinDomainModel>> = _history.asStateFlow()

    init {
        loadHistory()
    }

    private fun loadHistory() {
        viewModelScope.launch {
            try {
                val historyList = getHistoryUseCase() // получение истории
                _history.value = historyList
            } catch (e: Exception) {
                _history.value = emptyList()
            }
        }
    }
}
