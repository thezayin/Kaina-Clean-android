package com.thezayin.kainaclean.estimate.domain.usecases

import com.thezayin.kainaclean.estimate.domain.repository.RequestEstimateRepository
import com.thezayin.kainaclean.util.Response
import kotlinx.coroutines.flow.Flow

class AddEstimate(val repository: RequestEstimateRepository) {
    operator fun invoke(
        userId: String,
        address: String,
        date: String,
        service: String,
        propertyType: String,
    ): Flow<Response<Boolean>> = repository.addEstimateToFirebase(
        userId,
        address,
        date,
        service,
        propertyType,
    )
}