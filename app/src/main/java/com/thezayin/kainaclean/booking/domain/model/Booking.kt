package com.thezayin.kainaclean.booking.domain.model

data class Booking(
    val userId: String? = null,
    val name: String? = null,
    val bookingId: String? = null,
    val email: String? = null,
    val contact: String? = null,
    val address: String? = null,
    val city: String? = null,
    val postCode: String? = null,
    val propertyType: String? = null,
    val service: String? = null,
    val date: String? = null,
    val status: Boolean? = false,
    val remarks: String? = null,
    val requestDate: String? = null,
)