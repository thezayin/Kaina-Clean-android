package com.thezayin.kainaclean.domain.repository

import com.thezayin.kainaclean.domain.model.Quote
import com.thezayin.kainaclean.util.Response
import kotlinx.coroutines.flow.Flow

interface QuoteRepository {

    fun getMyQuoteFromFireStore(userId: String): Flow<Response<List<Quote>>>

    fun addMyQuoteToFireStore(
        userId: String,
        name: String,
        email: String,
        contact: String,
        address: String,
        city: String,
        postCode: String,
        propertyType: String,
        service: String,
        date: String,
    ): Flow<Response<Boolean>>
}