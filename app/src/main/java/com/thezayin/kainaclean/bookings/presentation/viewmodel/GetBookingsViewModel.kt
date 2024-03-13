package com.thezayin.kainaclean.bookings.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thezayin.kainaclean.auth.domain.usecases.AuthenticationUseCases
import com.thezayin.kainaclean.bookings.domain.model.Bookings
import com.thezayin.kainaclean.bookings.domain.usecases.GetBookingsUseCases
import com.thezayin.kainaclean.util.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GetBookingsViewModel @Inject constructor(
    private val useCases: GetBookingsUseCases, private val authUseCases: AuthenticationUseCases
) : ViewModel() {

    var getBookingMutableState by mutableStateOf(GetBookingMutableState())
        private set
    var detailUiState by mutableStateOf(BookingsUiState())
        private set

    init {
        getBookings()
    }

    private fun getBookings() = viewModelScope.launch {
        useCases.getBookings(authUseCases.getCurrentUser.invoke()).collect { response ->
            detailUiState = detailUiState.copy(bookingList = response)
        }
    }

    fun getCurrentBookings(bookingId: String) = viewModelScope.launch {
        useCases.getCurrentBookings(bookingId).collect { response ->
            getBookingMutableState = getBookingMutableState.copy(bookingList = response)
        }
    }

    data class BookingsUiState(
        val bookingList: Response<List<Bookings>> = Response.Loading
    )

    data class GetBookingMutableState(
        val bookingList: Response<Bookings> = Response.Loading
    )
}
