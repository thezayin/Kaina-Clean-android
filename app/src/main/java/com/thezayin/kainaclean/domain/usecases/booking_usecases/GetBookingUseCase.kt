package com.thezayin.kainaclean.domain.usecases.booking_usecases

import com.thezayin.kainaclean.domain.repository.BookingRepository

class GetBookingUseCase(
    private val repo: BookingRepository
) {
    operator fun invoke(userId: String) = repo.getMyBookingFromFireStore(userId)
}