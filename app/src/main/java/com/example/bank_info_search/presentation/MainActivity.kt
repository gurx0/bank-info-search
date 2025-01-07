package com.example.bank_info_search.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import com.example.bank_info_search.di.appModule
import com.example.bank_info_search.presentation.components.AppNavigation
import com.example.bank_info_search.presentation.viewmodel.HistoryViewModel
import com.example.bank_info_search.presentation.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // инициализация Koin
        startKoin {
            androidContext(applicationContext)
            modules(appModule)
        }

        setContent {
            val mainViewModel: MainViewModel by viewModel()
            val historyViewModel: HistoryViewModel by viewModel()

            AppNavigation(
                mainViewModel = mainViewModel,
                historyViewModel = historyViewModel
            )
        }
    }
}
