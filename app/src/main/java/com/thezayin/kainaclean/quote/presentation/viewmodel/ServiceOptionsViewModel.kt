package com.thezayin.kainaclean.quote.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thezayin.kainaclean.services.domain.model.ServiceOptions
import com.thezayin.kainaclean.quote.domain.usecases.service.ServiceUseCases
import com.thezayin.kainaclean.util.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ServiceOptionsViewModel @Inject constructor(
    private val useCase: ServiceUseCases,
) : ViewModel() {
    var getServiceState by mutableStateOf(ServiceState())
        private set

    var selected:MutableLiveData<Boolean> = MutableLiveData(false)


    init {
        getServiceOptions()
    }

    private fun getServiceOptions() {
        viewModelScope.launch {
            useCase.serviceOptionsCase().collect { response ->
                getServiceState = getServiceState.copy(list = response)
            }
        }
    }

    data class ServiceState(
        val list: Response<List<ServiceOptions>> = Response.Loading
    )

}