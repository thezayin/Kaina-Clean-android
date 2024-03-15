package com.thezayin.kainaclean.qoute_history.domain.model

data class QuoteHistory(
    val userId: String? = null,
    val quoteId: String? = null,
    val serviceType: String? = null,
    val address: String? = null,
    val status: Boolean? = false,
    val remarks: String? = "pending",
    val currentDate: String? = null,
    val quote: String? = null
)