package com.thezayin.kainaclean.domain.usecases

data class AuthUseCases(
    val isUserAuth: IsUserAuth,
    val firebaseSignIn: FirebaseSignIn,
    val firebaseSignUp: FirebaseSignUp,
    val firebaseSignOut: FirebaseSignOut,
    val firebaseAuthState: FirebaseAuthState
)