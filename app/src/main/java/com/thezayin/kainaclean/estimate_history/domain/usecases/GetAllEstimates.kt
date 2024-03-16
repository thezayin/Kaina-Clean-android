package com.thezayin.kainaclean.estimate_history.domain.usecases

import com.thezayin.kainaclean.estimate_history.domain.repository.EstimateHistoryRepository

class GetAllEstimates(val repository: EstimateHistoryRepository) {
    operator fun invoke(userId: String) = repository.getMyEstimateFromFireStore(userId)
}