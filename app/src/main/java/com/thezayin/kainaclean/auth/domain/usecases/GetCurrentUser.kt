package com.thezayin.kainaclean.presentation.auth.domain.usecases

import com.thezayin.kainaclean.presentation.auth.domain.repository.AuthRepository
import javax.inject.Inject

class GetCurrentUser @Inject constructor(
    private val repository: AuthRepository
) {
    operator fun invoke() = repository.getCurrentUser()
}