package com.thezayin.kainaclean.quote.domain.model

data class QuoteService(
    val userId: String,
    val quoteId: String,
    val serviceType: String,
    val address: String,
    val date: String,
    val status: Boolean,
    val remarks: String,
    val currentDate: String,
    val quote: String
)