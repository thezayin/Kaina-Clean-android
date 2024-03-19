package com.thezayin.kainaclean.auth.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thezayin.kainaclean.auth.domain.usecases.AuthenticationUseCases
import com.thezayin.kainaclean.util.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val auth: AuthenticationUseCases
) : ViewModel() {

    val isUserAuthenticated get() = auth.isUserAuthenticated()

    private val _signInState = mutableStateOf<Response<Boolean>>(Response.Success(false))
    val signInState: State<Response<Boolean>> = _signInState

    private val _signUpState = mutableStateOf<Response<Boolean>>(Response.Success(false))
    val signUpState: State<Response<Boolean>> = _signUpState

    private val _signOutState = mutableStateOf<Boolean>(false)
    val signOutState: State<Boolean> = _signOutState

    private val _recoverPasswordState = mutableStateOf<Response<Boolean>>(Response.Success(false))
    val recoverPasswordState: State<Response<Boolean>> = _recoverPasswordState

    fun signIn(email: String, password: String) {
        viewModelScope.launch {
            auth.firebaseSignIn(
                email, password
            ).collect {
                _signInState.value = it
            }
        }
    }

    fun signUp(email: String, password: String) {
        viewModelScope.launch {
            auth.firebaseSignUp(
                email, password
            ).collect {
                _signUpState.value = it
            }
        }
    }

    fun logout() {
        viewModelScope.launch {
            auth.firebaseSignOut().collect {
                when (it) {
                    is Response.Success -> {
                        _signOutState.value = it.data
                    }

                    is Response.Failure -> {
                        _signOutState.value = false
                    }

                    is Response.Loading -> {
                      _signOutState.value = false
                    }
                }
            }
        }
    }

    fun recoverPassword(email: String) {
        viewModelScope.launch {
            auth.firebaseForgetPassword(email).collect {
                _recoverPasswordState.value = it
            }
        }
    }
}