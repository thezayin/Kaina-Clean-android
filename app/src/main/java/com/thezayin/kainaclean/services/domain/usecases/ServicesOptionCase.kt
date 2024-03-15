package com.thezayin.kainaclean.services.domain.usecases

import com.thezayin.kainaclean.services.domain.repository.ServiceOptionsRepository

class ServicesOptionCase(val repository: ServiceOptionsRepository) {
    suspend operator fun invoke() = repository.getServiceOptions()
}