package com.thezayin.kainaclean.presentation.auth

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thezayin.kainaclean.domain.repository.AuthRepository
import com.thezayin.kainaclean.domain.repository.ReloadUserResponse
import com.thezayin.kainaclean.domain.repository.RevokeAccessResponse
import com.thezayin.kainaclean.domain.repository.SendEmailVerificationResponse
import com.thezayin.kainaclean.domain.repository.SendPasswordResetEmailResponse
import com.thezayin.kainaclean.domain.repository.SignInResponse
import com.thezayin.kainaclean.domain.repository.SignUpResponse
import com.thezayin.kainaclean.util.Response.Loading
import com.thezayin.kainaclean.util.Response.Success
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val repo: AuthRepository
) : ViewModel() {

    val currentUserAuth = viewModelScope.launch {
        repo.isCurrentUserAuth()
    }

    var currentUserState by mutableStateOf(false)
    var signInResponse by mutableStateOf<SignInResponse>(Success(false))
        private set

    var signUpResponse by mutableStateOf<SignUpResponse>(Success(false))
        private set
    var sendEmailVerificationResponse by mutableStateOf<SendEmailVerificationResponse>(Success(false))
        private set

    var sendPasswordResetEmailResponse by mutableStateOf<SendPasswordResetEmailResponse>(
        Success(
            false
        )
    )

    fun getCurrentUser() {
        viewModelScope.launch {
            currentUserState = repo.isCurrentUserAuth()
        }
    }

    var revokeAccessResponse by mutableStateOf<RevokeAccessResponse>(Success(false))
        private set
    var reloadUserResponse by mutableStateOf<ReloadUserResponse>(Success(false))
        private set

    fun reloadUser() = viewModelScope.launch {
        reloadUserResponse = Loading
        reloadUserResponse = repo.reloadFirebaseUser()
    }

    val isEmailVerified get() = repo.currentUser?.isEmailVerified ?: false

    fun signOut() = repo.signOut()

    fun revokeAccess() = viewModelScope.launch {
        revokeAccessResponse = Loading
        revokeAccessResponse = repo.revokeAccess()
    }

    fun sendPasswordResetEmail(email: String) = viewModelScope.launch {
        sendPasswordResetEmailResponse = Loading
        sendPasswordResetEmailResponse = repo.sendPasswordResetEmail(email)
    }

    fun signInWithEmailAndPassword(email: String, password: String) = viewModelScope.launch {
        signInResponse = Loading
        signInResponse = repo.firebaseSignInWithEmailAndPassword(email, password)
    }

    fun signUpWithEmailAndPassword(email: String, password: String) = viewModelScope.launch {
        signUpResponse = Loading
        signUpResponse = repo.firebaseSignUpWithEmailAndPassword(email, password)
    }

    fun sendEmailVerification() = viewModelScope.launch {
        sendEmailVerificationResponse = Loading
        sendEmailVerificationResponse = repo.sendEmailVerification()
    }
}