package com.thezayin.kainaclean.services.presentation.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thezayin.analytics.dependencies.Analytics
import com.thezayin.analytics.qualifiers.GoogleAnalytics
import com.thezayin.kainaclean.services.domain.model.ServiceOptions
import com.thezayin.kainaclean.services.domain.usecases.ServiceUseCases
import com.thezayin.kainaclean.util.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ServiceOptionsViewModel @Inject constructor(
    private val useCase: ServiceUseCases,
    @GoogleAnalytics val analytics: Analytics
) : ViewModel() {
    var getServiceState by mutableStateOf(ServiceState())
        private set

    var selectedService by mutableStateOf("")

    var details by mutableStateOf("")

    init {
        getServiceOptions()
    }

    private fun getServiceOptions() {
        viewModelScope.launch {
            useCase.serviceOptionsCase().collect { response ->
                when (response) {
                    is Response.Success -> {
                        getServiceState = getServiceState.copy(list = response.data)
                    }

                    else -> {
                        Log.e("service view model", "Error getting service options")
                    }
                }
            }
        }
    }

    data class ServiceState(
        val list: List<ServiceOptions> = emptyList()
    )

    class ServiceDataState {
        var service = mutableStateListOf<ServiceOptions>()
        fun itemSelected(serviceOptions: ServiceOptions) {
            val iterator = service.listIterator()
            while (iterator.hasNext()) {
                val item = iterator.next()
                iterator.set(
                    if (item.id == serviceOptions.id) {
                        serviceOptions
                    } else {
                        item.copy(
                            isSelected = false
                        )
                    }
                )
            }
        }

        fun setNewList(serviceOptions: List<ServiceOptions>) {
            this.service = serviceOptions.toMutableStateList()
        }
    }
}