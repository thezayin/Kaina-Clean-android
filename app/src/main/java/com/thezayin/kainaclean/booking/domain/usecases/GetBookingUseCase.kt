package com.thezayin.kainaclean.presentation.booking.domain.usecases

import com.thezayin.kainaclean.presentation.booking.domain.repository.BookingRepository

class GetBookingUseCase(
    private val repo: BookingRepository
) {
    operator fun invoke(userId: String) = repo.getMyBookingFromFireStore(userId)
}