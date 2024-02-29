package com.thezayin.kainaclean.domain.usecases.quote_usecases

import com.thezayin.kainaclean.domain.repository.QuoteRepository

class GetQuoteUseCase(
    private val repo: QuoteRepository
) {
    operator fun invoke(userId: String) = repo.getMyQuoteFromFireStore(userId)
}