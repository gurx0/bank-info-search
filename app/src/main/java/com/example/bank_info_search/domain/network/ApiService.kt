package com.example.bank_info_search.domain.network

import com.example.bank_info_search.data.models.BinResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("/{bin}")
    suspend fun getBinDetails(@Path("bin") bin: String): BinResponse
}
