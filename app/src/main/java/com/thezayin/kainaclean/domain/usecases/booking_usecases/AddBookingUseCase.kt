package com.thezayin.kainaclean.domain.usecases.booking_usecases

import com.thezayin.kainaclean.domain.repository.BookingRepository

class AddBookingUseCase(
    private val repo: BookingRepository
) {
    operator fun invoke(
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
    ) = repo.addMyBookingToFireStore(
        userId,
        name,
        email,
        contact,
        address,
        city,
        postCode,
        propertyType,
        service,
        date,
    )
}