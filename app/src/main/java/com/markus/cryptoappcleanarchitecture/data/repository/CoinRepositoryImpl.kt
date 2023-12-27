package com.markus.cryptoappcleanarchitecture.data.repository

import com.markus.cryptoappcleanarchitecture.data.remote.CoinPaprikaApi
import com.markus.cryptoappcleanarchitecture.data.remote.dto.CoinDetailDto
import com.markus.cryptoappcleanarchitecture.data.remote.dto.CoinDto
import com.markus.cryptoappcleanarchitecture.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor( //Inject our API
    private val api: CoinPaprikaApi
) : CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}