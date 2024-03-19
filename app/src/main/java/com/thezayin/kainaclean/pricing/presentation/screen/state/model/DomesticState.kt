package com.thezayin.kainaclean.pricing.presentation.screen.state.model

import com.thezayin.kainaclean.pricing.domain.model.DomesticServices

data class DomesticState(
    val list: List<DomesticServices> = emptyList()
)