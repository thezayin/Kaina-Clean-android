package com.thezayin.kainaclean.pricing.presentation.screen.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thezayin.kainaclean.R

@Composable
fun PricingCard(price: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            colorResource(id = R.color.background)
        ),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 20.dp, horizontal = 25.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "$price£",
                color = colorResource(id = R.color.black),
                fontSize = 30.sp,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontFamily = FontFamily(Font(R.font.noto_sans_bold)),
            )
            Row(modifier = Modifier.padding(top = 40.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.ic_check),
                    contentDescription = "Commercial",
                    modifier = Modifier
                        .size(20.dp)
                        .padding(end = 5.dp)
                )
                Text(
                    text = "Tailored cleaning: general, deep, specialized.",
                    color = colorResource(id = R.color.grey),
                    fontSize = 11.sp,
                    fontFamily = FontFamily(Font(R.font.noto_sans_medium)),
                    textAlign = TextAlign.Start,
                )
            }

            Row(modifier = Modifier.padding(top = 15.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.ic_check),
                    contentDescription = "Commercial",
                    modifier = Modifier
                        .size(20.dp)
                        .padding(end = 5.dp)
                )
                Text(
                    text = "Meticulous attention for thorough surface cleaning.",
                    color = colorResource(id = R.color.grey),
                    fontSize = 11.sp,
                    fontFamily = FontFamily(Font(R.font.noto_sans_medium)),
                    textAlign = TextAlign.Start
                )
            }
            Row(modifier = Modifier.padding(top = 15.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.ic_check),
                    contentDescription = "Commercial",
                    modifier = Modifier
                        .size(20.dp)
                        .padding(end = 5.dp)
                )
                Text(
                    text = "Pro equipment, eco-friendly for effective results.",
                    color = colorResource(id = R.color.grey),
                    fontSize = 11.sp,
                    fontFamily = FontFamily(Font(R.font.noto_sans_medium)),
                    textAlign = TextAlign.Start
                )
            }
            Row(modifier = Modifier.padding(top = 15.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.ic_check),
                    contentDescription = "Commercial",
                    modifier = Modifier
                        .size(20.dp)
                        .padding(end = 5.dp)
                )
                Text(
                    text = "Experienced staff, exceptional service, every time.",
                    color = colorResource(id = R.color.grey),
                    fontSize = 11.sp,
                    fontFamily = FontFamily(Font(R.font.noto_sans_medium)),
                    textAlign = TextAlign.Start
                )
            }
            Row(modifier = Modifier.padding(top = 15.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.ic_check),
                    contentDescription = "Commercial",
                    modifier = Modifier
                        .size(20.dp)
                        .padding(end = 5.dp)
                )
                Text(
                    text = "Flexible scheduling for your convenience.",
                    color = colorResource(id = R.color.grey),
                    fontSize = 11.sp,
                    fontFamily = FontFamily(Font(R.font.noto_sans_medium)),
                    textAlign = TextAlign.Start,

                    )
            }
        }
    }
}