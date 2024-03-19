package com.thezayin.kainaclean.quote.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thezayin.analytics.dependencies.Analytics
import com.thezayin.analytics.qualifiers.GoogleAnalytics
import com.thezayin.kainaclean.auth.domain.usecases.AuthenticationUseCases
import com.thezayin.kainaclean.home.domain.model.Home
import com.thezayin.kainaclean.home.domain.usecases.HomeUseCase
import com.thezayin.kainaclean.quote.domain.usecases.QuoteUseCases
import com.thezayin.kainaclean.util.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel @Inject constructor(
    private val useCases: QuoteUseCases,
    private val authUseCases: AuthenticationUseCases,
    private val homeUseCase: HomeUseCase,
    @GoogleAnalytics val analytics: Analytics
) : ViewModel() {

    private val _sendQuote = mutableStateOf<Response<Boolean>>(Response.Success(false))
    val sendQuote: State<Response<Boolean>> = _sendQuote

    var getHomeState by mutableStateOf(ServiceState())
        private set

    init {
        getServices()
    }

    fun sendQuote(
        serviceType: String,
        address: String,
        quote: String,
    ) {
        viewModelScope.launch {
            useCases.quoteServiceUseCase(
                userId = authUseCases.getCurrentUser.invoke(),
                address = address,
                serviceType = serviceType,
                quote = quote,
            ).collect {
                _sendQuote.value = it
            }
        }
    }

    private fun getServices() {
        viewModelScope.launch {
            homeUseCase.homeItem().collect { response ->
                getHomeState = getHomeState.copy(list = response)
            }
        }
    }

    data class ServiceState(
        val list: Response<List<Home>> = Response.Loading
    )
}

