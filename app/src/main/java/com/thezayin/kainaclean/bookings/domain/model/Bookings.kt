package com.thezayin.kainaclean.bookings.domain.model

data class Bookings(
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