package com.thezayin.kainaclean.pricing.presentation.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thezayin.kainaclean.pricing.domain.model.CommercialServices
import com.thezayin.kainaclean.pricing.domain.model.DomesticServices
import com.thezayin.kainaclean.pricing.domain.model.PropertyType
import com.thezayin.kainaclean.pricing.domain.usecase.property.PropertyUseCases
import com.thezayin.kainaclean.pricing.domain.usecase.serices.ServicesUseCases
import com.thezayin.kainaclean.pricing.presentation.screen.state.model.CommercialState
import com.thezayin.kainaclean.pricing.presentation.screen.state.model.DomesticState
import com.thezayin.kainaclean.pricing.presentation.screen.state.model.PropertyState
import com.thezayin.kainaclean.util.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PricingViewModel @Inject constructor(
    private val useCase: PropertyUseCases, var servicesUseCases: ServicesUseCases
) : ViewModel() {
    var getPropertyType by mutableStateOf(PropertyState())
        private set

    var getDomesticType by mutableStateOf(DomesticState())
        private set

    var getCommercialType by mutableStateOf(CommercialState())
        private set

    var selectedProperty by mutableStateOf("")
    var selectedService by mutableStateOf("")
    var price by mutableStateOf("0")

    init {
        getPropertyType()
        getDomesticList()
        getCommercialList()
    }

    private fun getDomesticList() {
        viewModelScope.launch {
            servicesUseCases.domesticService().collect { response ->
                when (response) {
                    is Response.Success -> {
                        getDomesticType = getDomesticType.copy(list = response.data)
                    }

                    else -> {
                        Log.e("PricingViewModel", "Error getting domestic options")
                    }
                }
            }
        }
    }

    private fun getCommercialList() {
        viewModelScope.launch {
            servicesUseCases.commercialService().collect { response ->
                when (response) {
                    is Response.Success -> {
                        getCommercialType = getCommercialType.copy(list = response.data)
                    }

                    else -> {
                        Log.e("PricingViewModel", "Error getting commercial options")
                    }
                }
            }
        }
    }

    private fun getPropertyType() {
        viewModelScope.launch {
            useCase.propertyCase().collect { response ->
                when (response) {
                    is Response.Success -> {
                        getPropertyType = getPropertyType.copy(list = response.data)
                    }

                    else -> {
                        Log.e("PricingViewModel", "Error getting property options")
                    }
                }
            }
        }
    }



}