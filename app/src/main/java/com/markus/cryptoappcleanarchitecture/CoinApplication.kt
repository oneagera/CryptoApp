package com.markus.cryptoappcleanarchitecture

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp //Add dagger hilt to our application context
class CoinApplication : Application() //add to android manifest as android:name".CoinApplication"
