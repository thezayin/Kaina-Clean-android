package com.thezayin.kainaclean.domain.usecases

import com.thezayin.kainaclean.domain.repository.AuthRepository
import javax.inject.Inject

class IsUserAuth @Inject constructor(
    private val repository: AuthRepository
) {
    operator fun invoke() = repository.isUserAuthInFirebase()
}