package com.thezayin.kainaclean.estimate.domain.repository

import com.thezayin.kainaclean.util.Response
import kotlinx.coroutines.flow.Flow

interface RequestEstimateRepository {

    fun addEstimateToFirebase(
        userId: String,
        address: String,
        date: String,
        service: String,
        propertyType: String,
    ): Flow<Response<Boolean>>
}