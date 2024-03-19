package com.thezayin.kainaclean.pricing.presentation.screen.state.model

import com.thezayin.kainaclean.pricing.domain.model.PropertyType

data class PropertyState(
    val list: List<PropertyType> = emptyList()
)