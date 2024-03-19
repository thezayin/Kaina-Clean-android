package com.thezayin.kainaclean.pricing.domain.model

import java.util.UUID

data class PropertyType(
    val id: UUID = UUID.randomUUID(),
    val name: String? = null,
    val isSelected: Boolean? = true
)