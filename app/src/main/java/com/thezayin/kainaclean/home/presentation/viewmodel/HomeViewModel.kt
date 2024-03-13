package com.thezayin.kainaclean.home.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thezayin.kainaclean.home.domain.model.Home
import com.thezayin.kainaclean.home.domain.usecases.HomeUseCase
import com.thezayin.kainaclean.util.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(val useCase: HomeUseCase) : ViewModel() {

    var getHomeState by mutableStateOf(HomeIconState())
        private set

    init {
        getIcons()
    }

    private fun getIcons() {
        viewModelScope.launch {
            useCase.homeItem().collect { response ->
                getHomeState = getHomeState.copy(list = response)
            }
        }
    }

    data class HomeIconState(
        val list: Response<List<Home>> = Response.Loading
    )
}