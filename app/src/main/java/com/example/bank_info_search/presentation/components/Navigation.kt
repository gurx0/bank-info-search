package com.example.bank_info_search.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.example.bank_info_search.presentation.screen.HistoryScreen
import com.example.bank_info_search.presentation.screen.MainScreen
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.bank_info_search.presentation.screen.SettingsScreen
import com.example.bank_info_search.presentation.viewmodel.HistoryViewModel
import com.example.bank_info_search.presentation.viewmodel.MainViewModel
import com.example.bank_info_search.presentation.viewmodel.ThemeViewModel


sealed class Screen(val route: String, val title: String, val icon: ImageVector) {
    data object Main : Screen("main", "Main", Icons.Default.Home)
    data object History : Screen("history", "History", Icons.Default.Info)
    data object Settings : Screen("settings", "Settings", Icons.Default.Settings)
}

@Composable
fun AppNavigation(
    mainViewModel: MainViewModel,
    historyViewModel: HistoryViewModel,
    themeViewModel: ThemeViewModel
) {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNavigationBar(navController = navController) }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Screen.Main.route,
            modifier = androidx.compose.ui.Modifier.padding(paddingValues)
        ) {
            composable(Screen.Main.route) {
                MainScreen(
                    viewModel = mainViewModel,
                    onNavigateToHistory = { navController.navigate(Screen.History.route) }
                )
            }
            //обновление на каждое открытие
            composable(Screen.History.route) {
                LaunchedEffect(Unit) {
                    historyViewModel.refreshHistory()
                }
                HistoryScreen(viewModel = historyViewModel)
            }
            composable(Screen.Settings.route) {
                SettingsScreen(themeViewModel)
            }
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val screens = listOf(Screen.Main, Screen.History, Screen.Settings)
    val currentDestination = navController.currentBackStackEntryAsState().value?.destination?.route

    NavigationBar {
        screens.forEach { screen ->
            NavigationBarItem(
                selected = currentDestination == screen.route,
                onClick = {
                    if (currentDestination != screen.route) {
                        navController.navigate(screen.route) {
                            popUpTo(navController.graph.startDestinationId) { saveState = true }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
                icon = { Icon(screen.icon, contentDescription = screen.title) },
                label = { Text(screen.title) }
            )
        }
    }
}
