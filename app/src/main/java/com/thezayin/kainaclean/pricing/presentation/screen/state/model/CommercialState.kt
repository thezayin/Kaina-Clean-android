package com.thezayin.kainaclean.pricing.presentation.screen.state.model

import com.thezayin.kainaclean.pricing.domain.model.CommercialServices

data class CommercialState(
    val list: List<CommercialServices> = emptyList()
)