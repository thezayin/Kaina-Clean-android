package com.thezayin.kainaclean.pricing.data.repository

import com.thezayin.kainaclean.pricing.domain.model.PropertyType
import com.thezayin.kainaclean.pricing.domain.repository.PropertyTypeRepository
import com.thezayin.kainaclean.util.Response
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PropertyTypeRepositoryImpl @Inject constructor() : PropertyTypeRepository {
    override suspend fun getPropertyTypes(): Flow<Response<List<PropertyType>>> = flow {
        try {
            emit(Response.Loading)
            val propertyTypes = listOf(
                PropertyType(name = "Domestic", isSelected = true),
                PropertyType(name = "Commercial", isSelected = false),
            )
            emit(Response.Success(propertyTypes))
        } catch (e: Exception) {
            emit(Response.Failure(e.localizedMessage ?: "An error occurred"))
        }
    }
}