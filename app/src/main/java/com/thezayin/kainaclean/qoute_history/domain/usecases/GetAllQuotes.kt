package com.thezayin.kainaclean.qoute_history.domain.usecases

import com.thezayin.kainaclean.qoute_history.domain.repository.QuoteHistoryRepository

class GetAllQuotes(val repository: QuoteHistoryRepository) {
    operator fun invoke(userId: String) = repository.getMyQuotesFromFireStore(userId)
}