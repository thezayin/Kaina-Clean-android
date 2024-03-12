package com.thezayin.kainaclean.presentation.auth.domain.usecases

import com.thezayin.kainaclean.presentation.auth.domain.repository.AuthRepository
import javax.inject.Inject

class FirebaseSignIn @Inject constructor(
    private val repository: AuthRepository
) {
    operator fun invoke(email: String, password: String) =
        repository.firebaseSignIn(email, password)
}