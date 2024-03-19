package com.thezayin.kainaclean.pricing.data.repository

import com.thezayin.kainaclean.R
import com.thezayin.kainaclean.pricing.domain.model.DomesticServices
import com.thezayin.kainaclean.pricing.domain.repository.DomesticRepository
import com.thezayin.kainaclean.util.Response
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DomesticRepositoryImpl @Inject constructor() : DomesticRepository {
    override suspend fun getDomesticServices(): Flow<Response<List<DomesticServices>>> = flow {
        try {
            emit(Response.Loading)
            val commercialList = listOf(
                DomesticServices(
                    name = "End of Tenancy Cleaning",
                    icon = R.drawable.ic_cleaning_tenc,
                    price = "150",
                    isSelected = false
                ),
                DomesticServices(
                    name = "Deep Cleaning",
                    icon = R.drawable.ic_cleaning_deep,
                    price = "150",
                    isSelected = false
                ),
                DomesticServices(
                    name = "After Builders Cleaning",
                    price = "150",
                    icon = R.drawable.ic_cleaning_after_builders,
                    isSelected = false
                ),
                DomesticServices(
                    name = "Sparkle Cleaning",
                    price = "150",
                    icon = R.drawable.ic_cleaning_sparkle,
                    isSelected = false
                ),
                DomesticServices(
                    name = "Kitchen & Oven Deep Cleaning",
                    icon = R.drawable.ic_cleaning_kitchen,
                    price = "150",
                    isSelected = false
                ),
                DomesticServices(
                    name = "General Cleaning",
                    price = "150",
                    icon = R.drawable.ic_cleaning_general,
                    isSelected = false
                ),
                DomesticServices(
                    name = "Pre-Tenancy Cleaning",
                    price = "150",
                    icon = R.drawable.ic_cleaning_tenc,
                    isSelected = false
                ),
            )

            emit(Response.Success(commercialList))

        } catch (e: Exception) {
            emit(Response.Failure(e.localizedMessage ?: "An error occurred"))
        }
    }
}