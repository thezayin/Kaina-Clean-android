package com.thezayin.kainaclean.booking_history.presentation.screen.details

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.thezayin.kainaclean.R
import com.thezayin.kainaclean.booking_history.presentation.component.BookingsDetailsCard
import com.thezayin.kainaclean.booking_history.presentation.viewmodel.BookingHistoryViewModel
import com.thezayin.kainaclean.main.component.TopBar
import com.thezayin.kainaclean.main.component.dialogs.LoadingDialog
import com.thezayin.kainaclean.main.component.dialogs.NetworkDialog
import com.thezayin.kainaclean.util.Constants
import com.thezayin.kainaclean.util.Response
import com.thezayin.kainaclean.util.checkForInternet

@Destination
@Composable
fun BookingDetailsScreen(
    navigator: DestinationsNavigator,
    bookingId: String
) {
    val bookingViewModel: BookingHistoryViewModel = hiltViewModel()
    val bookingUiState = bookingViewModel.getBookingMutableState
    var checkNetwork by remember { mutableStateOf(false) }
    val showProgressBar = remember { mutableStateOf(false) }
    val context = LocalContext.current

    if (!checkForInternet(context)) {
        checkNetwork = true
    }

    if (checkNetwork) {
        NetworkDialog(showDialog = { checkNetwork = it })
    }

    if (showProgressBar.value) {
        LoadingDialog()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding()
            .background(color = colorResource(id = R.color.background))
    ) {
        TopBar(
            modifier = Modifier
                .padding(horizontal = Constants.HORIZONTAL_PADDING)
                .padding(top = 20.dp, bottom = 40.dp), title = "Bookings Details"
        ) {
            navigator.navigateUp()
        }
        when (bookingUiState.bookingList) {
            is Response.Loading -> {
                showProgressBar.value = true
                bookingViewModel.getCurrentBookings(bookingId)
            }

            is Response.Failure -> {
                navigator.navigateUp()
                showProgressBar.value = false
                Toast.makeText(
                    context,
                    "Error: ${bookingUiState.bookingList.e}",
                    Toast.LENGTH_LONG
                ).show()
            }

            is Response.Success -> {
                showProgressBar.value = false
                BookingsDetailsCard(bookingUiState.bookingList.data)
            }
        }
    }
}