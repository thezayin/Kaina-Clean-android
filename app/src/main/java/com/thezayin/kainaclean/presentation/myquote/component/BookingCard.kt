package com.thezayin.kainaclean.presentation.mybooking.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thezayin.kainaclean.R
import com.thezayin.kainaclean.domain.model.Booking

@Composable
fun BookingCard(
    booking: Booking
) {
    val color: Int = if (booking.status == "Accepted") {
        R.color.green
    } else {
        R.color.red
    }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(top = 20.dp, bottom = 2.dp)
            .background(color = colorResource(id = R.color.white)),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 5.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.white),
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, end = 20.dp),
            horizontalArrangement = Arrangement.End
        ) {
            Text(
                text = "${booking.status}",
                fontSize = 14.sp,
                fontStyle = FontStyle.Italic,
                color = colorResource(
                    id = color
                )
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp)
                .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Date: ${booking.requestDate}",
                fontSize = 12.sp,
                fontStyle = FontStyle.Normal,
                color = colorResource(
                    id = R.color.text_color
                )
            )
            Text(
                text = "Post Code: ${booking.postCode}",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(
                    id = R.color.text_color
                )
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp)
                .padding(horizontal = 20.dp),
        ) {
            Text(
                text = "${booking.address}",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(
                    id = R.color.text_color
                )
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp)
                .padding(horizontal = 20.dp),
        ) {
            Text(
                text = "Property Type: ${booking.propertyType}",
                fontSize = 12.sp,
                fontStyle = FontStyle.Normal,
                color = colorResource(
                    id = R.color.text_color
                )
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp)
                .padding(horizontal = 20.dp),
        ) {
            Text(
                text = "Service Type: ${booking.service}",
                fontSize = 12.sp,
                fontStyle = FontStyle.Normal,
                color = colorResource(
                    id = R.color.text_color
                )
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp)
                .padding(horizontal = 20.dp),
        ) {
            Text(
                text = "Remarks:",
                fontSize = 12.sp,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.ExtraBold,
                color = colorResource(
                    id = R.color.text_color
                )
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp, bottom = 20.dp)
                .padding(horizontal = 20.dp),
        ) {
            Text(
                text = "${booking.remarks}",
                fontSize = 12.sp,
                fontStyle = FontStyle.Italic,
                color = colorResource(
                    id = R.color.text_color
                )
            )
        }
    }
}