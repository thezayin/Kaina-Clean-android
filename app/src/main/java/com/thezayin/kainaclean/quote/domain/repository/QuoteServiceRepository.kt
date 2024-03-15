package com.thezayin.kainaclean.quote.domain.repository

import com.thezayin.kainaclean.util.Response
import kotlinx.coroutines.flow.Flow

interface QuoteServiceRepository {
    fun addQuoteService(
        userId: String,
        serviceType: String,
        address: String,
        quote: String,
    ): Flow<Response<Boolean>>
}