package com.thezayin.kainaclean.quote.domain.usecases

import com.thezayin.kainaclean.quote.domain.repository.QuoteServiceRepository

class QuoteServiceCase(val repository: QuoteServiceRepository) {
    operator fun invoke(
        userId: String,
        serviceType: String,
        address: String,
        date: String,
        quote: String,
    ) = repository.addQuoteService(userId, serviceType, address, date, quote)
}