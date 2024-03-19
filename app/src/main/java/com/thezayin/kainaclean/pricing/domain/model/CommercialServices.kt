package com.thezayin.kainaclean.pricing.domain.model

import java.util.UUID

data class CommercialServices(
    val id: UUID = UUID.randomUUID(),
    val name: String? = null,
    val icon: Int? = null,
    val price:String? = null,
    val isSelected: Boolean? = null
)