package com.thezayin.kainaclean.qoute_history.domain.usecases

import com.thezayin.kainaclean.qoute_history.domain.repository.QuoteHistoryRepository

class GetCurrentQuoteHistory(
    private val repo: QuoteHistoryRepository
) {
    operator fun invoke(quoteId: String) = repo.getCurrentQuoteFromFireStore(quoteId)
}