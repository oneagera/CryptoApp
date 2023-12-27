package com.markus.cryptoappcleanarchitecture.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.markus.cryptoappcleanarchitecture.domain.model.Coin

data class CoinDto(
    val id: String,
    @SerializedName("is_active")
    val isActive: Boolean,
    val isNew: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)

fun CoinDto.toCoin(): Coin { //maps CoinDto to Coin.kt API to Ui
    return Coin(
        id = id,
        isActive = isActive,
        name = name,
        rank = rank,
        symbol = symbol
    )
}