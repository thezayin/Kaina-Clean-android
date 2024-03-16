package com.thezayin.kainaclean.estimate_history.domain.model

data class EstimateHistory(
    val userId: String? = null,
    val estimateId: String? = null,
    val address: String? = null,
    val date: String? = null,
    val status: Boolean? = false,
    val addedDate: String? = null,
    val serviceRequired: String? = null,
    val propertyType: String? = null,
    val remarks: String? = "pending",
)