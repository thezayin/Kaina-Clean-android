package com.thezayin.kainaclean.pricing.domain.usecase.property

import com.thezayin.kainaclean.pricing.domain.repository.PropertyTypeRepository

class PropertiesCase(val propertyTypeRepository: PropertyTypeRepository) {
    suspend operator fun invoke() = propertyTypeRepository.getPropertyTypes()
}