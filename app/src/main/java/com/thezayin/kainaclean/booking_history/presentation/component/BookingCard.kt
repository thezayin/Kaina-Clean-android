package com.thezayin.kainaclean.booking_history.presentation.component

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
import com.thezayin.kainaclean.R
import com.thezayin.kainaclean.booking_history.domain.model.BookingHistory
import com.thezayin.kainaclean.util.Constants.BOUNDARY_CARD_RADIUS
import com.thezayin.kainaclean.util.Constants.BOUNDARY_CARD_SIZE
import com.thezayin.kainaclean.util.Constants.CARDS_CORNERS
import com.thezayin.kainaclean.util.Constants.CARD_COLUMN_PADDING_START
import com.thezayin.kainaclean.util.Constants.CARD_IMAGE_SIZE
import com.thezayin.kainaclean.util.Constants.CARD_ROW_PADDING
import com.thezayin.kainaclean.util.Constants.CARD_STROKE
import com.thezayin.kainaclean.util.Constants.CARD_SUB_TEXT_SIZE
import com.thezayin.kainaclean.util.Constants.CARD_TEXT_ABOVE_PADDING
import com.thezayin.kainaclean.util.Constants.CARD_TEXT_HISTORY_WIDTH
import com.thezayin.kainaclean.util.Constants.HORIZONTAL_PADDING
import com.thezayin.kainaclean.util.Constants.TEXT_SIZE_NORMAL
import com.thezayin.kainaclean.util.Constants.TEXT_SUBTITLE_SIZE

@Composable
fun BookingCard(bookingHistory: BookingHistory, callBack: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = HORIZONTAL_PADDING)
            .clickable { callBack() },
        colors = CardDefaults.cardColors(
            colorResource(id = R.color.background)
        ),
        shape = RoundedCornerShape(CARDS_CORNERS),
        border = BorderStroke(CARD_STROKE, colorResource(id = R.color.grey_level_5))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(CARD_ROW_PADDING)
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(BOUNDARY_CARD_RADIUS))
                    .size(BOUNDARY_CARD_SIZE)
                    .background(colorResource(id = R.color.light_purple))
                    .align(Alignment.CenterVertically),
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_check),
                    contentDescription = null,
                    modifier = Modifier
                        .size(CARD_IMAGE_SIZE)
                        .align(Alignment.Center),
                    contentScale = ContentScale.Fit,
                    alignment = Alignment.Center,
                )
            }

            Column(modifier = Modifier.padding(start = CARD_COLUMN_PADDING_START)) {
                Text(
                    text = bookingHistory.address!!,
                    modifier = Modifier.widthIn(max = CARD_TEXT_HISTORY_WIDTH),
                    color = colorResource(
                        id = R.color.text_color
                    ),
                    fontSize = TEXT_SIZE_NORMAL,
                    fontFamily = FontFamily(Font(R.font.noto_sans_bold)),
                    fontWeight = FontWeight.Medium
                )
                Row(
                    modifier = Modifier.padding(top = CARD_TEXT_ABOVE_PADDING)
                ) {
                    Text(
                        text = "Service: ",
                        color = colorResource(
                            id = R.color.grey_level_2

                        ),
                        fontSize = CARD_SUB_TEXT_SIZE,
                        fontWeight = FontWeight.Medium,
                        fontFamily = FontFamily(Font(R.font.noto_sans_bold)),
                    )
                    Text(
                        text = bookingHistory.service!!,
                        color = colorResource(
                            id = R.color.grey_level_2
                        ),
                        fontFamily = FontFamily(Font(R.font.noto_sans_regular)),
                        modifier = Modifier.widthIn(max = 120.dp),
                        fontSize = CARD_SUB_TEXT_SIZE,
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
                        colorResource(id = if (bookingHistory.status == true) R.color.light_green else R.color.light_yellow_level_3)
                    )
                ) {
                    Text(
                        text = if (bookingHistory.status == true) "Success" else "Pending",
                        fontSize = TEXT_SUBTITLE_SIZE,
                        fontFamily = FontFamily(Font(R.font.noto_sans_medium)),
                        fontWeight = FontWeight.Medium,
                        color = colorResource(id = if (bookingHistory.status == true) R.color.green else R.color.light_yellow_level_2),
                        modifier = Modifier.padding(
                            vertical = 4.dp, horizontal = 12.dp
                        )

                    )
                }

                Text(
                    text = bookingHistory.date!!,
                    color = colorResource(id = R.color.grey_level_2),
                    fontSize = CARD_SUB_TEXT_SIZE,
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