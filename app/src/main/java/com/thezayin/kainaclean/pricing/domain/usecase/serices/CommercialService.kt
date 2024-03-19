package com.thezayin.kainaclean.pricing.domain.usecase.serices

import com.thezayin.kainaclean.pricing.domain.repository.CommercialRepository

class CommercialService(val repository: CommercialRepository) {
    suspend operator fun invoke() = repository.getCommercialTypes()
}