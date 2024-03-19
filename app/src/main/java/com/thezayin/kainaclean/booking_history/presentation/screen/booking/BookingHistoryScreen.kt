package com.thezayin.kainaclean.booking_history.presentation.screen.booking

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.thezayin.kainaclean.R
import com.thezayin.kainaclean.booking_history.presentation.component.BookingCard
import com.thezayin.kainaclean.booking_history.presentation.viewmodel.BookingHistoryViewModel
import com.thezayin.kainaclean.destinations.BookingDetailsScreenDestination
import com.thezayin.kainaclean.main.component.TopBar
import com.thezayin.kainaclean.main.component.dialogs.LoadingDialog
import com.thezayin.kainaclean.main.component.dialogs.NetworkDialog
import com.thezayin.kainaclean.util.Constants.HORIZONTAL_PADDING
import com.thezayin.kainaclean.util.Constants.TEXT_SUBTITLE
import com.thezayin.kainaclean.util.Response
import com.thezayin.kainaclean.util.checkForInternet
import kotlinx.coroutines.launch

@Destination
@Composable
fun BookingHistoryScreen(
    navigator: DestinationsNavigator
) {
    val viewModel: BookingHistoryViewModel = hiltViewModel()
    val bookingUiState = viewModel.detailUiState
    var checkNetwork by remember { mutableStateOf(false) }
    val showProgressBar = remember { mutableStateOf(false) }

    val scope = rememberCoroutineScope()
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
                .padding(horizontal = HORIZONTAL_PADDING)
                .padding(top = 20.dp),
            title = "Booking History"
        ) {
            navigator.navigateUp()
        }
        Column(
            modifier = Modifier
                .padding(HORIZONTAL_PADDING)
                .padding(top = 20.dp)
                .background(color = colorResource(id = R.color.background))
        ) {
            Text(
                text = "Click on desired card to check details",
                fontSize = TEXT_SUBTITLE,
                fontFamily = FontFamily(Font(R.font.noto_sans_regular)),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            when (bookingUiState.bookingList) {
                is Response.Loading -> {
                    showProgressBar.value = true
                }

                is Response.Success -> {
                    showProgressBar.value = false
                    LazyVerticalGrid(columns = GridCells.Fixed(1)) {
                        items(bookingUiState.bookingList.data.sortedBy { it.requestDate }) { bookings ->
                            BookingCard(bookingHistory = bookings) {
                                scope.launch {
                                    navigator.navigate(
                                        BookingDetailsScreenDestination(bookings.bookingId!!),
                                    )
                                }
                            }
                        }
                    }
                }

                else -> {
                    showProgressBar.value = false
                    Text(
                        text = "There is no data",
                        fontFamily = FontFamily(Font(R.font.noto_sans_regular)),
                    )
                }
            }
        }
    }
}




