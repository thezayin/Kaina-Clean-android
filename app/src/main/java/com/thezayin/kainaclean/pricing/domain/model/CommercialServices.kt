package com.thezayin.kainaclean.pricing.domain.model

import java.util.UUID

data class CommercialServices(
    val id: UUID = UUID.randomUUID(),
    val name: String? = "",
    val icon: Int? = null,
    val price:String? = "",
    val isSelected: Boolean? = false
)