package com.thezayin.kainaclean.presentation.main

import androidx.lifecycle.ViewModel
import com.thezayin.kainaclean.presentation.auth.domain.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repo: AuthRepository
) : ViewModel() {

//    init {
//        getAuthState()
//    }
//
//    fun getAuthState() = repo.getAuthState(viewModelScope)
//
//    val isEmailVerified get() = repo.currentUser?.isEmailVerified ?: false
}

