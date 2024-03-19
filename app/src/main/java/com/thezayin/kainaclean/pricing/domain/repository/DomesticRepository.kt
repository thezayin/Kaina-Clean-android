package com.thezayin.kainaclean.pricing.domain.repository

import com.thezayin.kainaclean.pricing.domain.model.DomesticServices
import com.thezayin.kainaclean.util.Response
import kotlinx.coroutines.flow.Flow

interface DomesticRepository {
    suspend fun getDomesticServices(): Flow<Response<List<DomesticServices>>>
}