package com.thezayin.kainaclean.domain.model

data class Quote(
    val userId: String? = null,
    val name: String? = null,
    val quoteId: String? = null,
    val email: String? = null,
    val contact: String? = null,
    val address: String? = null,
    val city: String? = null,
    val postCode: String? = null,
    val propertyType: String? = null,
    val service: String? = null,
    val date: String? = null,
    val status: String? = "Pending",
    val remarks: String? = null,
    val requestDate: String? = null,
)