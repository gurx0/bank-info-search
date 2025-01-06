package com.example.bank_info_search.utils

import androidx.room.TypeConverter
import com.example.bank_info_search.data.models.BinDomainModel
import com.google.gson.Gson

class Converters {
    @TypeConverter
    fun fromBinDomainModel(response: BinDomainModel): String {
        return Gson().toJson(response)
    }

    @TypeConverter
    fun toBinDomainModel(data: String): BinDomainModel {
        return Gson().fromJson(data, BinDomainModel::class.java)
    }
}
