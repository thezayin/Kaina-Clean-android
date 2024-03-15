package com.thezayin.kainaclean.services.domain.repository

import com.thezayin.kainaclean.services.domain.model.ServiceOptions
import com.thezayin.kainaclean.util.Response
import kotlinx.coroutines.flow.Flow

interface ServiceOptionsRepository {
    suspend fun getServiceOptions(): Flow<Response<List<ServiceOptions>>>
}