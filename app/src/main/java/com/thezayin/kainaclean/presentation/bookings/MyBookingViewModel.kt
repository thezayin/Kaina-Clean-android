package com.thezayin.kainaclean.presentation.bookings

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thezayin.kainaclean.domain.model.Booking
import com.thezayin.kainaclean.domain.usecases.auth_usecases.AuthenticationUseCases
import com.thezayin.kainaclean.domain.usecases.booking_usecases.BookingUseCases
import com.thezayin.kainaclean.util.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyBookingsViewModel @Inject constructor(
    private val useCases: BookingUseCases, private val authUseCases: AuthenticationUseCases
) : ViewModel() {

    var detailUiState by mutableStateOf(BookingsUiState())
        private set

    init {
        getBookings()
    }

    private fun getBookings() = viewModelScope.launch {
        useCases.getBookingUseCase(authUseCases.getCurrentUser.invoke()).collect { response ->
            detailUiState = detailUiState.copy(bookingList = response)
        }
    }

    data class BookingsUiState(
        val bookingList: Response<List<Booking>> = Response.Loading
    )
}
