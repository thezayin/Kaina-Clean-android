package com.thezayin.kainaclean.bookings.domain.repository

import com.thezayin.kainaclean.bookings.domain.model.Bookings
import com.thezayin.kainaclean.util.Response
import kotlinx.coroutines.flow.Flow

interface GetBookingsRepository {
    fun getMyBookingFromFireStore(userId: String): Flow<Response<List<Bookings>>>

    fun getCurrentBookingFromFireStore(bookingId: String): Flow<Response<Bookings>>
}