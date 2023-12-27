package com.markus.cryptoappcleanarchitecture.presentation.coin_list

import com.markus.cryptoappcleanarchitecture.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
