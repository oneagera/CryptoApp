package com.markus.cryptoappcleanarchitecture.presentation.coin_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.markus.cryptoappcleanarchitecture.common.Resource
import com.markus.cryptoappcleanarchitecture.domain.use_case.get_coins.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase //inject dependency getCoinsUseCase
) : ViewModel() {

    private val _state = mutableStateOf(CoinListState()) //
    val state: State<CoinListState> = _state //public version os State accessible in the composables

    init {
        getCoins()
    }

    private fun getCoins() {
        getCoinsUseCase().onEach { result ->
            //since its an operator fun invoke, this class can be called as a fun
            //onEach element that this flow emits/onEach resource object
            when (result) {
                is Resource.Success -> {
                    _state.value = CoinListState(coins = result.data ?: emptyList())
                }

                is Resource.Error -> {
                    _state.value =
                        CoinListState(error = result.message ?: "An unexpected error occurred")
                }

                is Resource.Loading -> {
                    _state.value = CoinListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope) //launch the flow in  a coroutine
    }
}

