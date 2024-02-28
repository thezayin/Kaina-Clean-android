package com.thezayin.kainaclean.domain.usecases.auth_usecases

import com.thezayin.kainaclean.domain.repository.AuthRepository
import javax.inject.Inject

class GetCurrentUser @Inject constructor(
    private val repository: AuthRepository
) {
    operator fun invoke() = repository.getCurrentUser()
}