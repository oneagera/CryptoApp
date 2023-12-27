package com.markus.cryptoappcleanarchitecture.di

import com.markus.cryptoappcleanarchitecture.common.Constants
import com.markus.cryptoappcleanarchitecture.data.remote.CoinPaprikaApi
import com.markus.cryptoappcleanarchitecture.data.repository.CoinRepositoryImpl
import com.markus.cryptoappcleanarchitecture.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class) //InstallIn determines how long our dependencies live. In this case(SingletonComponent) they live as long as the application does
object AppModule {

    //funs that create our dependency
    @Provides //provides a dependency
    @Singleton //ensures there is only a single instance of whatever the fun returns throughout our app
    fun providePaprikaApi(): CoinPaprikaApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()) //use Gson to serialize and deserialize the Json data
            .build()
            .create(CoinPaprikaApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinPaprikaApi): CoinRepository {
        return CoinRepositoryImpl(api)
    }

}