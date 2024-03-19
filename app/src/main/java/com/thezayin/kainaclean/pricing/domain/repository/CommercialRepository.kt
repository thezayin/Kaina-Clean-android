package com.thezayin.kainaclean.pricing.domain.repository

import com.thezayin.kainaclean.pricing.domain.model.CommercialServices
import com.thezayin.kainaclean.util.Response
import kotlinx.coroutines.flow.Flow

interface CommercialRepository {
    suspend fun getCommercialTypes(): Flow<Response<List<CommercialServices>>>
}