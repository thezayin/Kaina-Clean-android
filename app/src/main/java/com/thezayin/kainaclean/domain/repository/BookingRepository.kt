package com.thezayin.kainaclean.domain.repository

import com.thezayin.kainaclean.domain.model.Booking
import com.thezayin.kainaclean.util.Response
import kotlinx.coroutines.flow.Flow

interface BookingRepository {

    fun getMyBookingFromFireStore(userId: String): Flow<Response<List<Booking>>>

    fun addMyBookingToFireStore(
        userId: String,
        name: String,
        email: String,
        contact: String,
        address: String,
        city: String,
        postCode: String,
        propertyType: String,
        service: String,
        date: String,
    ): Flow<Response<Boolean>>
}