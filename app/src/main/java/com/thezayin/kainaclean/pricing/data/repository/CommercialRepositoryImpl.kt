package com.thezayin.kainaclean.pricing.data.repository

import com.thezayin.kainaclean.R
import com.thezayin.kainaclean.pricing.domain.model.CommercialServices
import com.thezayin.kainaclean.pricing.domain.repository.CommercialRepository
import com.thezayin.kainaclean.util.Response
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CommercialRepositoryImpl @Inject constructor() : CommercialRepository {
    override suspend fun getCommercialTypes(): Flow<Response<List<CommercialServices>>> = flow {
        try {
            emit(Response.Loading)
            val commercialList = listOf(
                CommercialServices(
                    name = "Hotel & Restaurant Cleaning",
                    price = "150",
                    icon = R.drawable.ic_cleaning_hotel,
                    isSelected = true
                ),
                CommercialServices(
                    name = "Gyms & Clubs Cleaning",
                    price = "150",
                    icon = R.drawable.ic_cleaning_gym,
                    isSelected = false
                ),
                CommercialServices(
                    name = "Schools & Colleges Cleaning",
                    price = "150",
                    icon = R.drawable.ic_cleaning_school,
                    isSelected = false
                ),
                CommercialServices(
                    name = "Hostel Cleaning",
                    price = "150",
                    icon = R.drawable.ic_cleaning_hostel,
                    isSelected = false
                ),
                CommercialServices(
                    name = "Carpet Cleaning",
                    price = "150",
                    icon = R.drawable.ic_cleaning_carpet,
                    isSelected = false
                ),
                CommercialServices(
                    name = "Hand Floor Scrubbing",
                    price = "150",
                    icon = R.drawable.ic_cleaning_hand_scrubing,
                    isSelected = false
                ),
            )

            emit(Response.Success(commercialList))

        } catch (e: Exception) {
            emit(Response.Failure(e.localizedMessage ?: "An error occurred"))
        }

    }
}