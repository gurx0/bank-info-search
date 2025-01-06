package com.example.bank_info_search.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.bank_info_search.presentation.viewmodel.AppNavigation
import com.example.bank_info_search.presentation.viewmodel.HistoryViewModel
import com.example.bank_info_search.presentation.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.startKoin
import org.koin.android.ext.koin.androidContext
import com.example.bank_info_search.di.appModule

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //инициализация коин
        startKoin {
            androidContext(applicationContext)
            modules(appModule)
        }

        setContent {
            val navController = rememberNavController()

            //коин для получения viewModel
            val mainViewModel: MainViewModel by viewModel()
            val historyViewModel: HistoryViewModel by viewModel()

            AppNavigation(
                navController = navController,
                mainViewModel = mainViewModel,
                historyViewModel = historyViewModel
            )
        }
    }
}
