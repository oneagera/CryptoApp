package com.markus.cryptoappcleanarchitecture.domain.repository

import com.markus.cryptoappcleanarchitecture.data.remote.dto.CoinDetailDto
import com.markus.cryptoappcleanarchitecture.data.remote.dto.CoinDto

//to define our coin fun repository
//fake repo that simulates behavior of our API. Helpful for test cases

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}