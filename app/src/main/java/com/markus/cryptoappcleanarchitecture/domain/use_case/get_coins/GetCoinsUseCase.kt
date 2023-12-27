package com.markus.cryptoappcleanarchitecture.domain.use_case.get_coins

import com.markus.cryptoappcleanarchitecture.common.Resource
import com.markus.cryptoappcleanarchitecture.data.remote.dto.toCoin
import com.markus.cryptoappcleanarchitecture.domain.model.Coin
import com.markus.cryptoappcleanarchitecture.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor( //Inject our repository/fake repository not Impl
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = repository.getCoins().map { it.toCoin() } //map our coinListDto to Coin
            emit(Resource.Success(coins))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
            //display a localized msg to that error and if null display our string msg
        } catch (e: IOException) {
            emit(Resource.Error("couldn't reach server. Check your internet connection"))
        }
    }
    //In Kotlin, the invoke operator is a special function that can be defined in a class,
    //allowing instances of that class to be called as if they were functions. We can call this UseCase class as if it were a fun
    //Returns Flow from coroutines of type Resource of type List of type Coin. Flow because we want to emit multiple values over a period of time
    //In this case Success, Error, Loading
    
}