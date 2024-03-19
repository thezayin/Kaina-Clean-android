package com.thezayin.kainaclean.pricing.domain.usecase.serices

import com.thezayin.kainaclean.pricing.domain.repository.DomesticRepository

class DomesticService(val repository: DomesticRepository) {
    suspend operator fun invoke() = repository.getDomesticServices()
}