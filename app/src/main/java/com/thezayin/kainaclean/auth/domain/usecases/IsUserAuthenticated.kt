package com.thezayin.kainaclean.auth.domain.usecases

import com.thezayin.kainaclean.auth.domain.repository.AuthRepository
import javax.inject.Inject

class IsUserAuthenticated @Inject constructor(
    private val repository: AuthRepository
) {
    operator fun invoke() = repository.isUserAuthenticatedInFirebase()
}