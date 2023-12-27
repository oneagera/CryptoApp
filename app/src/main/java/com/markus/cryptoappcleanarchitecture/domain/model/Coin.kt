package com.markus.cryptoappcleanarchitecture.domain.model

//contains data displayed in the ui from CoinDto

data class Coin(
    val id: String,
    val isActive: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String
)


