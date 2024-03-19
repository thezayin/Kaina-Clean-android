package com.thezayin.kainaclean.services.domain.usecases

import com.thezayin.kainaclean.quote.domain.repository.QuoteServiceRepository

class QuoteServiceCase(val repository: QuoteServiceRepository) {
    operator fun invoke(
        userId: String,
        serviceType: String,
        address: String,
        quote: String,
    ) = repository.addQuoteService(userId, serviceType, address, quote)
}