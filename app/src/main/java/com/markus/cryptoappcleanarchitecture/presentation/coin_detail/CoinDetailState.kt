package com.markus.cryptoappcleanarchitecture.presentation.coin_detail

import com.markus.cryptoappcleanarchitecture.domain.model.Coin
import com.markus.cryptoappcleanarchitecture.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
