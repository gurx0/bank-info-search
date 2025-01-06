package com.example.bank_info_search.utils

import androidx.room.TypeConverter
import com.example.bank_info_search.data.models.BinResponse
import com.google.gson.Gson

class Converters {
    @TypeConverter
    fun fromBinResponse(response: BinResponse): String {
        return Gson().toJson(response)
    }

    @TypeConverter
    fun toBinResponse(data: String): BinResponse {
        return Gson().fromJson(data, BinResponse::class.java)
    }
}
