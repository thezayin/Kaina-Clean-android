package com.thezayin.kainaclean.estimate.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thezayin.kainaclean.auth.domain.usecases.AuthenticationUseCases
import com.thezayin.kainaclean.estimate.domain.usecases.AddEstimateUseCases
import com.thezayin.kainaclean.util.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddEstimateViewModel @Inject constructor(
    private val useCases: AddEstimateUseCases,
    private val authUseCases: AuthenticationUseCases
) : ViewModel() {
    private val _sendEstimate = mutableStateOf<Response<Boolean>>(Response.Success(false))
    val sendEstimate: State<Response<Boolean>> = _sendEstimate

    fun sendEstimate(
        address: String,
        date: String,
        propertyType: String,
        service: String
    ) {
        viewModelScope.launch {
            useCases.addEstimate(
                userId = authUseCases.getCurrentUser.invoke(),
                address = address,
                date = date,
                propertyType = propertyType,
                service = service
            ).collect {
                _sendEstimate.value = it
            }
        }
    }
}