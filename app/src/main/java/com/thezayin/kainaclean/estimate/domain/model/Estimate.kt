package com.thezayin.kainaclean.estimate.domain.model

data class Estimate(
    val userId: String? = null,
    val estimateId: String? = null,
    val address: String? = null,
    val date: String? = null,
    val status: Boolean? = false,
    val addedDate: String? = null,
    val serviceRequired: String? = null,
    val propertyType: String? = null
)