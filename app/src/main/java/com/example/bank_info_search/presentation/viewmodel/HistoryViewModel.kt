package com.example.bank_info_search.presentation.viewmodel

import com.example.bank_info_search.domain.useCases.GetHistoryUseCase
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bank_info_search.data.models.HistoryItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HistoryViewModel(
    private val getHistoryUseCase: GetHistoryUseCase
) : ViewModel() {

    private val _history = MutableStateFlow<List<HistoryItem>>(emptyList())
    val history: StateFlow<List<HistoryItem>> = _history.asStateFlow()

    init {
        loadHistory()
    }

    private fun loadHistory() {
        viewModelScope.launch {
            try {
                val historyList = getHistoryUseCase()
                _history.value = historyList.sortedByDescending { it.id }
            } catch (e: Exception) {
                _history.value = emptyList()
            }
        }
    }
}
