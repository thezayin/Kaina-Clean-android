package com.thezayin.kainaclean.pricing.domain.usecase.property

import com.thezayin.kainaclean.pricing.domain.repository.PropertyTypeRepository

class PropertiesCase(val repository:PropertyTypeRepository) {
    suspend operator fun invoke() = repository.getPropertyTypes()
}