package com.thezayin.kainaclean.presentation.auth.domain.usecases

data class AuthenticationUseCases(
    val firebaseAuthState: FirebaseAuthState,
    val firebaseSignIn: FirebaseSignIn,
    val firebaseSignOut: FirebaseSignOut,
    val firebaseSignUp: FirebaseSignUp,
    val isUserAuthenticated: IsUserAuthenticated,
    val firebaseForgetPassword: FirebaseForgetPassword,
    val getCurrentUser: GetCurrentUser
)