package com.thezayin.kainaclean.estimate_history.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thezayin.kainaclean.auth.domain.usecases.AuthenticationUseCases
import com.thezayin.kainaclean.estimate_history.domain.model.EstimateHistory
import com.thezayin.kainaclean.estimate_history.domain.usecases.EstimateHistoryUseCases
import com.thezayin.kainaclean.util.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EstimateHistoryViewModel @Inject constructor(
    private val useCases: EstimateHistoryUseCases,
    private val authUseCases: AuthenticationUseCases,
) : ViewModel() {
    var getCurrentEstimate by mutableStateOf(GetCurrentEstimateMutableState())
        private set

    var getAllEstimates by mutableStateOf(EstimateUiState())
        private set

    init {
        getEstimates()
    }

    private fun getEstimates() = viewModelScope.launch {
        useCases.getAllEstimates(authUseCases.getCurrentUser.invoke()).collect { response ->
            getAllEstimates = getAllEstimates.copy(estimateList = response)
        }
    }

    fun getCurrentEstimate(quoteId: String) = viewModelScope.launch {
        useCases.getCurrentEstimateHistory(quoteId).collect { response ->
            getCurrentEstimate =
                getCurrentEstimate.copy(estimateList = response)
        }
    }

    data class EstimateUiState(
        val estimateList: Response<List<EstimateHistory>> = Response.Loading
    )

    data class GetCurrentEstimateMutableState(
        val estimateList: Response<EstimateHistory> = Response.Loading
    )
}