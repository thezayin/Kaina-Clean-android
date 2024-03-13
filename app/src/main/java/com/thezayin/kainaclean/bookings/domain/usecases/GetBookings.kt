package com.thezayin.kainaclean.bookings.domain.usecases

import com.thezayin.kainaclean.bookings.domain.repository.GetBookingsRepository

class GetBookings(
    private val repo: GetBookingsRepository
) {
    operator fun invoke(userId: String) = repo.getMyBookingFromFireStore(userId)
}