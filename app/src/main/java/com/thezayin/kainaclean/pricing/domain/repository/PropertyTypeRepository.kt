package com.thezayin.kainaclean.pricing.domain.repository

import com.thezayin.kainaclean.pricing.domain.model.PropertyType
import com.thezayin.kainaclean.util.Response
import kotlinx.coroutines.flow.Flow

interface PropertyTypeRepository {
   suspend fun getPropertyTypes(): Flow<Response<List<PropertyType>>>
}