package com.thezayin.kainaclean.services

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.thezayin.kainaclean.R
import com.thezayin.kainaclean.chatbot.presentation.component.TopBar

@Destination
@Composable
fun Services(
    navigator: DestinationsNavigator
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.background))
            .statusBarsPadding()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
                .background(color = colorResource(id = R.color.background))
        ) {
            TopBar(
                modifier = Modifier,
                title = "Services",
                callBack = { navigator.navigateUp() }
            )

            Column(
                modifier = Modifier
                    .padding(10.dp)
                    .background(color = colorResource(id = R.color.background))
            ) {
//                when (bookingUiState.bookingList) {
//                    is Response.Loading -> {
//                        CircularProgressIndicator(
//                            modifier = Modifier
//                                .fillMaxSize()
//                                .wrapContentSize(align = Alignment.Center)
//                        )
//                    }
//
//                    is Response.Success -> {
//                        LazyVerticalGrid(columns = GridCells.Fixed(1)) {
//                            items(bookingUiState.bookingList.data.sortedBy { it.date }
//                                ?: emptyList()) { booking ->
//                                BookingCard(booking = booking)
//                            }
//                        }
//                    }
//
//                    else -> {
//                        Text(text = "There is no data")
//                    }
//                }
            }
        }
    }
}