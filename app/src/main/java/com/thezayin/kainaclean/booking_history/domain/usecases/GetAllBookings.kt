package com.thezayin.kainaclean.booking_history.domain.usecases

import com.thezayin.kainaclean.booking_history.domain.repository.BookingHistoryRepository

class GetAllBookings(
    private val repo: BookingHistoryRepository
) {
    operator fun invoke(userId: String) = repo.getMyBookingFromFireStore(userId)
}