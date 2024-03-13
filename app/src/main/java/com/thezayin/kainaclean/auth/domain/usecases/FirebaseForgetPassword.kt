package com.thezayin.kainaclean.auth.domain.usecases

import com.thezayin.kainaclean.auth.domain.repository.AuthRepository
import javax.inject.Inject

class FirebaseForgetPassword @Inject constructor(
    private val repository: AuthRepository
) {
    operator fun invoke(email: String) = repository.firebaseRecoverPassword(email)
}