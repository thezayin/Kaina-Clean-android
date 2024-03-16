package com.thezayin.kainaclean.estimate_history.domain.repository

import com.thezayin.kainaclean.estimate_history.domain.model.EstimateHistory
import com.thezayin.kainaclean.util.Response
import kotlinx.coroutines.flow.Flow

interface EstimateHistoryRepository {
    fun getMyEstimateFromFireStore(userId: String): Flow<Response<List<EstimateHistory>>>

    fun getCurrentEstimateFromFireStore(estimateId: String): Flow<Response<EstimateHistory>>
}