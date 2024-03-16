package com.thezayin.kainaclean.estimate_history.domain.usecases

import com.thezayin.kainaclean.estimate_history.domain.repository.EstimateHistoryRepository

class GetCurrentEstimateHistory(val repository: EstimateHistoryRepository) {
    operator fun invoke(estimateId: String) = repository.getCurrentEstimateFromFireStore(estimateId)
}