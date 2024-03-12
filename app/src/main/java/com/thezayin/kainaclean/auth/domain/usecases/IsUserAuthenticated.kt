package com.thezayin.kainaclean.presentation.auth.domain.usecases

import com.thezayin.kainaclean.presentation.auth.domain.repository.AuthRepository
import javax.inject.Inject

class IsUserAuthenticated @Inject constructor(
    private val repository: AuthRepository
) {
    operator fun invoke() = repository.isUserAuthenticatedInFirebase()
}