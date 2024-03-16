package com.thezayin.kainaclean.qoute_history.presentation.screens.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thezayin.kainaclean.R
import com.thezayin.kainaclean.qoute_history.domain.model.QuoteHistory

@Composable
fun QuoteCard(quote: QuoteHistory, callBack: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp)
            .clickable { callBack() },
        colors = CardDefaults.cardColors(
            colorResource(id = R.color.background)
        ),
        shape = RoundedCornerShape(4.dp),
        border = BorderStroke(1.dp, colorResource(id = R.color.grey_level_5))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(40.dp))
                    .size(48.dp)
                    .background(colorResource(id = R.color.light_purple))
                    .align(Alignment.CenterVertically),
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_check),
                    contentDescription = null,
                    modifier = Modifier
                        .size(20.dp)
                        .align(Alignment.Center),
                    contentScale = ContentScale.Fit,
                    alignment = Alignment.Center,
                )
            }

            Column(modifier = Modifier.padding(start = 12.dp)) {
                Text(
                    text = quote.address!!,
                    fontFamily = FontFamily(Font(R.font.noto_sans_bold)),
                    modifier = Modifier.widthIn(max = 180.dp),
                    color = colorResource(
                        id = R.color.text_color
                    ),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
                Row(
                    modifier = Modifier.padding(top = 4.dp)
                ) {
                    Text(
                        text = "Service: ",
                        color = colorResource(
                            id = R.color.grey_level_2
                        ),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        fontFamily = FontFamily(Font(R.font.noto_sans_bold)),
                    )
                    Text(
                        text = quote.serviceType!!,
                        color = colorResource(
                            id = R.color.grey_level_2
                        ),
                        fontFamily = FontFamily(Font(R.font.noto_sans_regular)),
                        modifier = Modifier.widthIn(max = 120.dp),
                        fontSize = 14.sp,
                    )
                }
            }

            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.Center
            ) {
                Card(
                    modifier = Modifier,
                    shape = RoundedCornerShape(40.dp),
                    colors = CardDefaults.cardColors(
                        colorResource(id = if (quote.status == true) R.color.light_green else R.color.light_yellow_level_3)
                    )
                ) {
                    Text(
                        text = if (quote.status == true) "Success" else "Pending",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium,
                        fontFamily = FontFamily(Font(R.font.noto_sans_bold)),
                        color = colorResource(id = if (quote.status == true) R.color.green else R.color.light_yellow_level_2),
                        modifier = Modifier.padding(
                            vertical = 4.dp, horizontal = 12.dp
                        )
                    )
                }

                Text(
                    text = quote.currentDate!!,
                    color = colorResource(id = R.color.grey_level_2),
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.noto_sans_medium)),
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier
                        .padding(top = 4.dp, end = 4.dp)
                        .widthIn(70.dp)
                )
            }
        }
    }
}