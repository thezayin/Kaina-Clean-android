package com.thezayin.kainaclean.booking.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thezayin.kainaclean.auth.domain.usecases.AuthenticationUseCases
import com.thezayin.kainaclean.booking.domain.model.Booking
import com.thezayin.kainaclean.booking.domain.usecases.BookingUseCases
import com.thezayin.kainaclean.util.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookingViewModel @Inject constructor(
    private val useCases: BookingUseCases,
    private val authUseCases: AuthenticationUseCases
) : ViewModel() {
    private val _bookingData = mutableStateOf<Response<List<Booking>>>(Response.Loading)
    val BookingData: State<Response<List<Booking>>> = _bookingData

    private val _sendBooking = mutableStateOf<Response<Boolean>>(Response.Success(false))
    val sendBooking: State<Response<Boolean>> = _sendBooking


    fun sendBooking(
        name: String,
        email: String,
        contact: String,
        address: String,
        city: String,
        postCode: String,
        propertyType: String,
        service: String,
        date: String,
    ) {
        viewModelScope.launch {
            useCases.addBookingUseCase(
                userId = authUseCases.getCurrentUser.invoke(),
                name = name,
                email = email,
                contact = contact,
                address = address,
                city = city,
                postCode = postCode,
                propertyType = propertyType,
                service = service,
                date = date,
            ).collect {
                _sendBooking.value = it
            }
        }
    }
}

