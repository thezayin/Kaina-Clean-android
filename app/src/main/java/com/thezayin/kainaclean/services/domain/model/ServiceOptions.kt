package com.thezayin.kainaclean.services.domain.model

import java.util.UUID

data class ServiceOptions(
    val id: UUID = UUID.randomUUID(),
    val name: String? = null,
    val icon: Int? = null,
    val details: String? = null,
    val isSelected: Boolean? = null,
)