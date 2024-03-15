package com.thezayin.kainaclean.services.data.repository

import com.thezayin.kainaclean.R
import com.thezayin.kainaclean.services.domain.model.ServiceOptions
import com.thezayin.kainaclean.services.domain.repository.ServiceOptionsRepository
import com.thezayin.kainaclean.util.Response
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ServiceOptionsRepositoryImpl @Inject constructor() : ServiceOptionsRepository {
    override suspend fun getServiceOptions(): Flow<Response<List<ServiceOptions>>> = flow {
        try {
            emit(Response.Loading)
            val list = listOf(
                ServiceOptions("1", "Car Wash", R.drawable.ic_stuf, true),
                ServiceOptions("2", "Laundry", R.drawable.ic_stuf, false),
                ServiceOptions("3", "House Cleaning", R.drawable.ic_stuf, false),
                ServiceOptions("4", "Carpet Cleaning", R.drawable.ic_stuf, false),
                ServiceOptions("5", "Sofa Cleaning", R.drawable.ic_stuf, false),
                ServiceOptions("6", "Pest Control", R.drawable.ic_stuf, false),
                ServiceOptions("7", "Kitchen Cleaning", R.drawable.ic_stuf, false),
                ServiceOptions("8", "Bathroom Cleaning", R.drawable.ic_stuf, false),
                ServiceOptions("9", "Water Tank Cleaning", R.drawable.ic_stuf, false),
                ServiceOptions("10", "AC Service", R.drawable.ic_stuf, false),
                ServiceOptions("11", "Plumbing", R.drawable.ic_stuf, false),
                ServiceOptions("12", "Electrical", R.drawable.ic_stuf, false),
                ServiceOptions("13", "Carpentry", R.drawable.ic_stuf, false),
                ServiceOptions("14", "Painting", R.drawable.ic_stuf, false),
                ServiceOptions("15", "Masonry", R.drawable.ic_stuf, false),
                ServiceOptions("16", "Gardening", R.drawable.ic_stuf, false),
                ServiceOptions("17", "Packing & Moving", R.drawable.ic_stuf, false),
                ServiceOptions("18", "Appliance Repair", R.drawable.ic_stuf, false),
                ServiceOptions("19", "Computer Repair", R.drawable.ic_stuf, false),
                ServiceOptions("20", "Mobile Repair", R.drawable.ic_stuf, false),
                ServiceOptions("21", "Car Service", R.drawable.ic_stuf, false),
                ServiceOptions("22", "Bike Service", R.drawable.ic_stuf, false),
                ServiceOptions("23", "Car Detailing", R.drawable.ic_stuf, false),
                ServiceOptions("24", "Bike Detailing", R.drawable.ic_stuf, false),
                ServiceOptions("25", "Car Painting", R.drawable.ic_stuf, false),
                ServiceOptions("26", "Bike Painting", R.drawable.ic_stuf, false),
                ServiceOptions("27", "Car Polishing", R.drawable.ic_stuf, false),
                ServiceOptions("28", "Bike Polishing", R.drawable.ic_stuf, false),
                ServiceOptions("29", "Car Wrapping", R.drawable.ic_stuf, false),
                ServiceOptions("30", "Bike Wrapping", R.drawable.ic_stuf, false),
                ServiceOptions("31", "Car Towing", R.drawable.ic_stuf, false),
                ServiceOptions("32", "B", R.drawable.ic_stuf, false)
            )
            emit(Response.Success(list))

        } catch (e: Exception) {
            emit(Response.Failure(e.localizedMessage ?: "An error occurred"))
        }
    }
}