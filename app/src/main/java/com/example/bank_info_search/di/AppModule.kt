package com.example.bank_info_search.di

import androidx.room.Room
import com.example.bank_info_search.data.AppDatabase
import com.example.bank_info_search.data.BinRepositoryImpl
import com.example.bank_info_search.domain.BinRepository
import com.example.bank_info_search.domain.useCases.GetBinDetailsUseCase
import com.example.bank_info_search.domain.useCases.GetHistoryUseCase
import com.example.bank_info_search.presentation.viewmodel.HistoryViewModel
import com.example.bank_info_search.presentation.viewmodel.MainViewModel
import com.example.bank_info_search.utils.RetrofitClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { RetrofitClient.apiService }
    single { Room.databaseBuilder(get(), AppDatabase::class.java, "app_db").build().historyDao() }
    factory { BinRepositoryImpl(get(), get()) as BinRepository }
    factory { GetBinDetailsUseCase(get()) }
    factory { GetHistoryUseCase(get()) }
    viewModel { MainViewModel(get()) }
    viewModel { HistoryViewModel(get()) }
}
