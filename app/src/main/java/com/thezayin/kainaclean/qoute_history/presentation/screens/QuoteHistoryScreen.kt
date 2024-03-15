package com.thezayin.kainaclean.qoute_history.presentation.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.thezayin.kainaclean.R
import com.thezayin.kainaclean.chatbot.presentation.component.TopBar
import com.thezayin.kainaclean.destinations.QuoteDetailsScreenDestination
import com.thezayin.kainaclean.qoute_history.presentation.screens.component.QuoteCard
import com.thezayin.kainaclean.qoute_history.presentation.viewmodel.QuoteHistoryViewModel
import com.thezayin.kainaclean.toast.Toast
import com.thezayin.kainaclean.util.Response
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.Q)
@Destination
@Composable
fun QuoteHistoryScreen(
    navigator: DestinationsNavigator
) {
    val quoteViewModel: QuoteHistoryViewModel = hiltViewModel()
    val quoteUiState = quoteViewModel.detailUiState

    val scope = rememberCoroutineScope()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.background))
            .statusBarsPadding()
            .navigationBarsPadding(),
    ) {
        Column(
            modifier = Modifier
                .background(color = colorResource(id = R.color.background))
                .fillMaxSize()

        ) {
            TopBar(modifier = Modifier, title = "Quote History") {
                navigator.navigateUp()
            }
            Column(
                modifier = Modifier
                    .padding(20.dp)
                    .background(color = colorResource(id = R.color.background))
            ) {
                when (quoteUiState.bookingList) {
                    is Response.Failure -> {
                        Toast(message = "UnExpected error please try again")
                    }

                    Response.Loading -> {
                        CircularProgressIndicator()
                    }

                    is Response.Success -> {
                        LazyColumn {
                            items(quoteUiState.bookingList.data.sortedBy { it.currentDate!!.toIntOrNull() }) { quote ->
                                QuoteCard(quote = quote) {
                                    scope.launch {
                                        navigator.navigate(
                                            QuoteDetailsScreenDestination(quote.quoteId!!)
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

