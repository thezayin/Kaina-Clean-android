package com.thezayin.kainaclean.qoute_history.domain.repository

import com.thezayin.kainaclean.qoute_history.domain.model.QuoteHistory
import com.thezayin.kainaclean.util.Response
import kotlinx.coroutines.flow.Flow

interface QuoteHistoryRepository {
    fun getMyQuotesFromFireStore(userId: String): Flow<Response<List<QuoteHistory>>>

    fun getCurrentQuoteFromFireStore(quoteId: String): Flow<Response<QuoteHistory>>
}