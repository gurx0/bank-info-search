package com.example.bank_info_search.presentation.viewmodel

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.bank_info_search.presentation.screen.HistoryScreen
import com.example.bank_info_search.presentation.screen.MainScreen
import com.example.bank_info_search.presentation.viewmodel.HistoryViewModel
import com.example.bank_info_search.presentation.viewmodel.MainViewModel

@Composable
fun AppNavigation(
    navController: NavHostController,
    mainViewModel: MainViewModel,
    historyViewModel: HistoryViewModel
) {
    NavHost(navController, startDestination = "main") {
        composable("main") {
            MainScreen(
                viewModel = mainViewModel,
                onNavigateToHistory = { navController.navigate("history") }
            )
        }
        composable("history") {
            HistoryScreen(viewModel = historyViewModel)
        }
    }
}
