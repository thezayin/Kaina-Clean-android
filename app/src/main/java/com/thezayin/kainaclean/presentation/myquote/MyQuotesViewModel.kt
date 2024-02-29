package com.thezayin.kainaclean.presentation.myquote

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thezayin.kainaclean.domain.model.Quote
import com.thezayin.kainaclean.domain.usecases.auth_usecases.AuthenticationUseCases
import com.thezayin.kainaclean.domain.usecases.quote_usecases.QuoteUseCases
import com.thezayin.kainaclean.util.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyQuotesViewModel @Inject constructor(
    private val useCases: QuoteUseCases, private val authUseCases: AuthenticationUseCases
) : ViewModel() {

    var detailUiState by mutableStateOf(QuoteUiState())
        private set

    init {
        getQuotes()
    }

    private fun getQuotes() = viewModelScope.launch {
        useCases.getQuoteUseCase(authUseCases.getCurrentUser.invoke()).collect { response ->
            detailUiState = detailUiState.copy(quoteList = response)
        }
    }

    data class QuoteUiState(
        val quoteList: Response<List<Quote>> = Response.Loading
    )
}
