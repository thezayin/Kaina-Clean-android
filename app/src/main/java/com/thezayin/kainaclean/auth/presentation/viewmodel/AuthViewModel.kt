package com.thezayin.kainaclean.auth.presentation.viewmodel

import android.util.Log
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

    private val _signOutState = mutableStateOf<Response<Boolean>>(Response.Success(false))
    val signOutState: State<Response<Boolean>> = _signOutState

    private val _authState = mutableStateOf<Boolean>(false)
    val authState: State<Boolean> = _authState

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
                Log.d("JejeView", _signUpState.value.toString())
            }
        }
    }

    fun signOut() {
        viewModelScope.launch {
            auth.firebaseSignOut().collect {
                _signOutState.value = it
                if (it == Response.Success(true)) {
                    _signOutState.value = Response.Success(false)
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

    fun getAuthState() {
        viewModelScope.launch {
            auth.firebaseAuthState().collect {
                _authState.value = it
            }
        }
    }
}