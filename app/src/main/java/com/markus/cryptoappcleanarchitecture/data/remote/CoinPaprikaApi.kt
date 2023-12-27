package com.markus.cryptoappcleanarchitecture.data.remote

import com.markus.cryptoappcleanarchitecture.data.remote.dto.CoinDetailDto
import com.markus.cryptoappcleanarchitecture.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi { //get data from API

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailDto
}