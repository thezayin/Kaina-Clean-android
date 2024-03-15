package com.thezayin.kainaclean.booking_history.presentation.screen.details

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.thezayin.kainaclean.R
import com.thezayin.kainaclean.booking_history.presentation.component.BookingsDetailsCard
import com.thezayin.kainaclean.booking_history.presentation.viewmodel.BookingHistoryViewModel
import com.thezayin.kainaclean.chatbot.presentation.component.TopBar
import com.thezayin.kainaclean.util.Response

@Destination
@Composable
fun BookingDetailsScreen(
    navigator: DestinationsNavigator,
    bookingId: String
) {
    val bookingViewModel: BookingHistoryViewModel = hiltViewModel()
    val bookingUiState = bookingViewModel.getBookingMutableState
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding()
            .background(color = colorResource(id = R.color.background))
    ) {
        TopBar(modifier = Modifier, title = "Bookings Details") {
            navigator.navigateUp()
        }
        when (bookingUiState.bookingList) {
            is Response.Loading -> {
                bookingViewModel.getCurrentBookings(bookingId)
            }

            is Response.Failure -> {
                Toast.makeText(
                    context,
                    "Error: ${bookingUiState.bookingList.e}",
                    Toast.LENGTH_LONG
                ).show()
            }

            is Response.Success -> {
                BookingsDetailsCard(bookingUiState.bookingList.data)
            }
        }
    }
}