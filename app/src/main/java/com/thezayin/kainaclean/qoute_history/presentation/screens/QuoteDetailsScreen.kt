package com.thezayin.kainaclean.qoute_history.presentation.screens

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
import com.thezayin.kainaclean.chatbot.presentation.component.TopBar
import com.thezayin.kainaclean.qoute_history.presentation.screens.component.QuoteDetailsCard
import com.thezayin.kainaclean.qoute_history.presentation.viewmodel.QuoteHistoryViewModel
import com.thezayin.kainaclean.util.Response

@Composable
@Destination
fun QuoteDetailsScreen(
    navigator: DestinationsNavigator,
    quoteId: String
) {
    val quoteViewModel: QuoteHistoryViewModel = hiltViewModel()
    val quoteUiState = quoteViewModel.getQuotesMutableState
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
        when (quoteUiState.bookingList) {
            is Response.Loading -> {
                quoteViewModel.getCurrentQuote(quoteId)
            }

            is Response.Failure -> {
                Toast.makeText(
                    context,
                    "Error: ${quoteUiState.bookingList.e}",
                    Toast.LENGTH_LONG
                ).show()
            }

            is Response.Success -> {
                QuoteDetailsCard(quoteUiState.bookingList.data)
            }
        }
    }
}