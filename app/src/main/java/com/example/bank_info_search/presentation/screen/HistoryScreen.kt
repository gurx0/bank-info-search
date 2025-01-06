package com.example.bank_info_search.presentation.screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.bank_info_search.presentation.viewmodel.HistoryViewModel
import androidx.compose.foundation.lazy.items


@Composable
fun HistoryScreen(viewModel: HistoryViewModel) {
    val history by viewModel.history.collectAsState()

    LazyColumn {
        items(history) { item ->
            Text("BIN: ${item} ")
        }
    }
}
