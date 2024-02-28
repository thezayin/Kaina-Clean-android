package com.thezayin.kainaclean.domain.usecases.quote_usecases

import com.thezayin.kainaclean.domain.repository.QuoteRepository

class AddQuoteUseCase(
    private val repo: QuoteRepository
) {
    operator fun invoke(
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
    ) = repo.addMyQuoteToFireStore(
        userId,
        name,
        email,
        contact,
        address,
        city,
        postCode,
        propertyType,
        service,
        date,
    )
}