package com.thezayin.kainaclean.home.presentation.component.navbottom

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.thezayin.analytics.events.AnalyticsEvent
import com.thezayin.kainaclean.R
import com.thezayin.kainaclean.destinations.BookingHistoryScreenDestination
import com.thezayin.kainaclean.destinations.BookingScreenFirstDestination
import com.thezayin.kainaclean.destinations.ChatBotScreenDestination
import com.thezayin.kainaclean.home.presentation.viewmodel.HomeViewModel

@Composable
fun HomeBottomNav(
    navigator: DestinationsNavigator, modifier: Modifier, viewModel: HomeViewModel
) {
    val analytics = viewModel.analytics
    Column(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
    ) {
        Button(
            onClick = {
                analytics.logEvent(AnalyticsEvent.BookingSelected("booking_selected"))
                navigator.navigate(BookingScreenFirstDestination)
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.btn_primary),
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(12.dp),

            ) {
            Text(
                text = "Request a Booking",
                fontFamily = FontFamily(Font(R.font.noto_sans_regular)),
                color = colorResource(id = R.color.white),
                fontSize = 20.sp
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier
                    .padding(start = 25.dp)
                    .padding(vertical = 10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_home_active),
                    contentDescription = "Home",
                    modifier = Modifier.size(20.dp)
                )
                Text(
                    text = "Home",
                    fontFamily = FontFamily(Font(R.font.noto_sans_regular)),
                    color = colorResource(id = R.color.text_color)
                )
            }

            Column(
                modifier = Modifier
                    .padding(vertical = 10.dp)
                    .clickable {
                        navigator.navigate(BookingHistoryScreenDestination)
                        analytics.logEvent(AnalyticsEvent.BookingHistorySelected("booking_history_selected"))
                    },
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_booking),
                    contentDescription = "Bookings",
                    modifier = Modifier.size(20.dp)
                )
                Text(
                    text = "Bookings",
                    fontFamily = FontFamily(Font(R.font.noto_sans_regular)),
                    color = colorResource(id = R.color.un_selected)
                )
            }

            Column(
                modifier = Modifier
                    .clickable {
                        navigator.navigate(ChatBotScreenDestination)
                        analytics.logEvent(AnalyticsEvent.ChatSelected("chat_selected"))
                    }
                    .padding(end = 25.dp)
                    .padding(vertical = 10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_chat),
                    contentDescription = "Chat",
                    modifier = Modifier.size(20.dp)
                )
                Text(
                    text = "Chat",
                    fontFamily = FontFamily(Font(R.font.noto_sans_regular)),
                    color = colorResource(id = R.color.un_selected)
                )
            }
        }
    }
}