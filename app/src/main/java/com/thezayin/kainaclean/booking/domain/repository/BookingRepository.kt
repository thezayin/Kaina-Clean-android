package com.thezayin.kainaclean.booking.domain.repository

import com.thezayin.kainaclean.booking.domain.model.Booking
import com.thezayin.kainaclean.util.Response
import kotlinx.coroutines.flow.Flow

interface BookingRepository {

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