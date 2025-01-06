package com.example.bank_info_search.domain

//датакласс, в который преобрзуются полученные данные для дальнейших операций
//не зависит от модели респонса

data class BinDomainModel(
    val number: NumberInfo?,
    val scheme: String?,
    val type: String?,
    val brand: String?,
    val prepaid: Boolean?,
    val country: CountryInfo?,
    val bank: BankInfo?
)

data class NumberInfo(
    val length: Int?,
    val luhn: Boolean?
)

data class CountryInfo(
    val numeric: String?,
    val alpha2: String?,
    val name: String?,
    val emoji: String?,
    val currency: String?,
    val latitude: Int?,
    val longitude: Int?,
)

data class BankInfo(
    val name: String?,
    val url: String?,
    val phone: String?,
    val city: String?
)
