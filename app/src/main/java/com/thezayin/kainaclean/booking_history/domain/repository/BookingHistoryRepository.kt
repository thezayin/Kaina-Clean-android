package com.thezayin.kainaclean.booking_history.domain.repository

import com.thezayin.kainaclean.booking_history.domain.model.BookingHistory
import com.thezayin.kainaclean.util.Response
import kotlinx.coroutines.flow.Flow

interface BookingHistoryRepository {
    fun getMyBookingFromFireStore(userId: String): Flow<Response<List<BookingHistory>>>

    fun getCurrentBookingFromFireStore(bookingId: String): Flow<Response<BookingHistory>>
}