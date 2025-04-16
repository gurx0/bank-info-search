package com.example.bank_info_search.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import com.example.bank_info_search.domain.di.appModule
import com.example.bank_info_search.presentation.components.AppNavigation
import com.example.bank_info_search.presentation.viewmodel.HistoryViewModel
import com.example.bank_info_search.presentation.viewmodel.MainViewModel
import com.example.bank_info_search.presentation.viewmodel.ThemeViewModel
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
            val themeViewModel: ThemeViewModel by viewModel()
            val isDarkTheme = themeViewModel.isDarkTheme.collectAsState()

            // Используем системную тему по умолчанию
            val darkTheme = isDarkTheme.value
            MyAppTheme(darkTheme) {
                AppNavigation(
                    mainViewModel = mainViewModel,
                    historyViewModel = historyViewModel,
                    themeViewModel = themeViewModel
                )
            }
        }
    }
}

@Composable
fun MyAppTheme(
    darkTheme: Boolean,
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) {
        darkColorScheme()
    } else {
        lightColorScheme()
    }

    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}
