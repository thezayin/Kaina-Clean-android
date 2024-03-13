package com.thezayin.kainaclean.bookings.presentation.screen.booking

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.thezayin.kainaclean.R
import com.thezayin.kainaclean.bookings.presentation.component.BookingCard
import com.thezayin.kainaclean.bookings.presentation.viewmodel.GetBookingsViewModel
import com.thezayin.kainaclean.chatbot.presentation.component.TopBar
import com.thezayin.kainaclean.destinations.BookingDetailsScreenDestination
import com.thezayin.kainaclean.util.Response
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Destination
@Composable
fun GetBookings(
    navigator: DestinationsNavigator
) {
    val bookingViewModel: GetBookingsViewModel = hiltViewModel()
    val bookingUiState = bookingViewModel.detailUiState

    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding()
            .background(color = colorResource(id = R.color.background))
    ) {
        TopBar(modifier = Modifier, title = "Bookings") {
            navigator.navigateUp()
        }
        Column(
            modifier = Modifier
                .padding(20.dp)
                .background(color = colorResource(id = R.color.background))
        ) {
            when (bookingUiState.bookingList) {
                is Response.Loading -> {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .fillMaxSize()
                            .wrapContentSize(align = Alignment.Center)
                    )
                }

                is Response.Success -> {
                    LazyVerticalGrid(columns = GridCells.Fixed(1)) {
                        items(bookingUiState.bookingList.data.sortedBy { it.requestDate }) { bookings ->
                            BookingCard(bookings = bookings) {
                                scope.launch {
                                    delay(1000)
                                    navigator.navigate(
                                        BookingDetailsScreenDestination(bookings.bookingId!!),
                                    )
                                }
                            }
                        }
                    }
                }

                else -> {
                    Text(text = "There is no data")
                }
            }
        }
    }
}




