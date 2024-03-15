package com.thezayin.kainaclean.booking_history.domain.usecases

import com.thezayin.kainaclean.booking_history.domain.repository.BookingHistoryRepository

class GetCurrentBookingHistory(
    private val repo: BookingHistoryRepository
) {
    operator fun invoke(bookingId: String) = repo.getCurrentBookingFromFireStore(bookingId)
}