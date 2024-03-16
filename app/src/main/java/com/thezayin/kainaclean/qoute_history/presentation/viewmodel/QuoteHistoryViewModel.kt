package com.thezayin.kainaclean.qoute_history.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thezayin.kainaclean.auth.domain.usecases.AuthenticationUseCases
import com.thezayin.kainaclean.qoute_history.domain.model.QuoteHistory
import com.thezayin.kainaclean.qoute_history.domain.usecases.QuotesUseCases
import com.thezayin.kainaclean.util.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuoteHistoryViewModel @Inject constructor(
    private val useCases: QuotesUseCases,
    private val authUseCases: AuthenticationUseCases,
) : ViewModel() {

    var getSelectedQuote by mutableStateOf(GetSelectedQuoteMutableState())
        private set
    var getAllQuotes by mutableStateOf(QuotesUiState())
        private set

    init {
        getQuotes()
    }

    private fun getQuotes() = viewModelScope.launch {
        useCases.getAllQuote(authUseCases.getCurrentUser.invoke()).collect { response ->
            getAllQuotes = getAllQuotes.copy(quoteList = response)
        }
    }

    fun getCurrentQuote(quoteId: String) = viewModelScope.launch {
        useCases.getCurrentQuoteHistory(quoteId).collect { response ->
            getSelectedQuote = getSelectedQuote.copy(quoteList = response)
        }
    }

    data class QuotesUiState(
        val quoteList: Response<List<QuoteHistory>> = Response.Loading
    )

    data class GetSelectedQuoteMutableState(
        val quoteList: Response<QuoteHistory> = Response.Loading
    )
}

