package com.thezayin.kainaclean.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.thezayin.kainaclean.R
import com.thezayin.kainaclean.presentation.destinations.FirstQuoteScreenDestination
import com.thezayin.kainaclean.presentation.destinations.MyQuotesDestination
import com.thezayin.kainaclean.presentation.home.slider.carousel.AutoSlidingCarousel

@Destination
@OptIn(ExperimentalPagerApi::class)
@Composable
fun HomeScreen(
    navigator: DestinationsNavigator
) {
    Box(modifier = Modifier.background(color = colorResource(id = R.color.background))) {
        Column(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .background(color = colorResource(id = R.color.background))
                .statusBarsPadding()
                .fillMaxSize()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row {
                    Image(
                        painter = painterResource(id = R.drawable.ic_menu),
                        contentDescription = "",
                        modifier = Modifier
                            .clip(shape = CircleShape)
                            .background(color = colorResource(id = R.color.light_purple))
                            .padding(10.dp)
                            .size(24.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.ic_search),
                        contentDescription = "",
                        modifier = Modifier
                            .padding(12.dp, 0.dp, 0.dp, 0.dp)
                            .clip(shape = CircleShape)
                            .background(color = colorResource(id = R.color.light_purple))
                            .padding(10.dp)
                            .size(24.dp)
                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.ic_notifcation),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(12.dp, 0.dp, 0.dp, 0.dp)
                        .clip(shape = CircleShape)
                        .background(color = colorResource(id = R.color.light_purple))
                        .padding(10.dp)
                        .size(24.dp)
                        .clickable {
                            navigator.navigate(MyQuotesDestination)
                        },
                    alignment = Alignment.CenterEnd
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                val images = listOf(
                    painterResource(id = R.drawable.ic_slide_first),
                    painterResource(id = R.drawable.ic_slide_sec),
                    painterResource(id = R.drawable.ic_slider_third),
                    painterResource(id = R.drawable.ic_slider_fourth),
                    painterResource(id = R.drawable.ic_slider_fifth),
                )
                Card(
                    shape = RoundedCornerShape(16.dp),
                ) {
                    AutoSlidingCarousel(
                        itemsCount = images.size,
                        itemContent = { index ->
                            Image(painter = images[index], contentDescription = "")
                        }
                    )
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(0.dp, 0.dp, 0.dp, 40.dp),
                verticalArrangement = Arrangement.Bottom
            ) {
                Button(
                    onClick = {
                        navigator.navigate(FirstQuoteScreenDestination)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.btn_primary),
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(12.dp),

                    ) {
                    Text(
                        text = "Request a Quote",
                        color = colorResource(id = R.color.white),
                        fontSize = 20.sp
                    )
                }
            }
        }
    }

}