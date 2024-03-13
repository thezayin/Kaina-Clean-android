package com.thezayin.kainaclean.quote.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thezayin.kainaclean.auth.domain.usecases.AuthenticationUseCases
import com.thezayin.kainaclean.quote.domain.usecases.QuoteUseCases
import com.thezayin.kainaclean.util.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel @Inject constructor(
    private val useCases: QuoteUseCases, private val authUseCases: AuthenticationUseCases
) : ViewModel() {

    private val _sendQuote = mutableStateOf<Response<Boolean>>(Response.Success(false))
    val sendQuote: State<Response<Boolean>> = _sendQuote

    fun sendQuote(
        serviceType: String,
        address: String,
        date: String,
        quote: String,
    ) {
        viewModelScope.launch {
            useCases.quoteServiceUseCase(
                userId = authUseCases.getCurrentUser.invoke(),
                address = address,
                serviceType = serviceType,
                quote = quote,
                date = date

            ).collect {
                _sendQuote.value = it
            }
        }
    }
}

