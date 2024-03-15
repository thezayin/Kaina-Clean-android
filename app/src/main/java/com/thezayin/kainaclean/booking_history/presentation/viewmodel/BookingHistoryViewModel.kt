package com.thezayin.kainaclean.booking_history.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thezayin.kainaclean.auth.domain.usecases.AuthenticationUseCases
import com.thezayin.kainaclean.booking_history.domain.model.BookingHistory
import com.thezayin.kainaclean.booking_history.domain.usecases.BookingHistoryUseCases
import com.thezayin.kainaclean.util.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookingHistoryViewModel @Inject constructor(
    private val useCases: BookingHistoryUseCases, private val authUseCases: AuthenticationUseCases
) : ViewModel() {

    var getBookingMutableState by mutableStateOf(GetBookingMutableState())
        private set
    var detailUiState by mutableStateOf(BookingsUiState())
        private set

    init {
        getBookings()
    }

    private fun getBookings() = viewModelScope.launch {
        useCases.getAllBookings(authUseCases.getCurrentUser.invoke()).collect { response ->
            detailUiState = detailUiState.copy(bookingList = response)
        }
    }

    fun getCurrentBookings(bookingId: String) = viewModelScope.launch {
        useCases.getCurrentBookingHistory(bookingId).collect { response ->
            getBookingMutableState = getBookingMutableState.copy(bookingList = response)
        }
    }

    data class BookingsUiState(
        val bookingList: Response<List<BookingHistory>> = Response.Loading
    )

    data class GetBookingMutableState(
        val bookingList: Response<BookingHistory> = Response.Loading
    )
}
