package com.thezayin.kainaclean.bookings.domain.usecases

import com.thezayin.kainaclean.bookings.domain.repository.GetBookingsRepository

class GetCurrentBookings(
    private val repo: GetBookingsRepository
) {
    operator fun invoke(bookingId: String) = repo.getCurrentBookingFromFireStore(bookingId)
}