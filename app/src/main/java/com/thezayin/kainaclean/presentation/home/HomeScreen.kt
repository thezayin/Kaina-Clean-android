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
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.thezayin.kainaclean.R
import com.thezayin.kainaclean.presentation.destinations.BookingScreenFirstDestination
import com.thezayin.kainaclean.presentation.destinations.MyBookingsDestination
import com.thezayin.kainaclean.presentation.home.drawer.model.DrawerItem
import com.thezayin.kainaclean.presentation.home.slider.carousel.AutoSlidingCarousel
import kotlinx.coroutines.launch

@Destination
@OptIn(ExperimentalPagerApi::class)
@Composable
fun HomeScreen(
    navigator: DestinationsNavigator
) {


    val drawerItem = listOf(
        DrawerItem(R.drawable.ic_home, "Home"),
        DrawerItem(R.drawable.ic_quote, "My Quotes"),
        DrawerItem(R.drawable.ic_booking, "My Booking"),
        DrawerItem(R.drawable.ic_calender, "Calender")
    )

    var selectedItem by remember {
        mutableStateOf(drawerItem[0])
    }

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(drawerContent = {
        ModalDrawerSheet {
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .background(color = colorResource(id = R.color.background))
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_icon),
                        contentDescription = null,
                        modifier = Modifier
                            .size(100.dp)
                    )
                    Text(
                        text = "Kaina Cleans",
                        fontWeight = FontWeight.ExtraBold,
                        color = colorResource(id = R.color.text_color),
                        fontSize = 30.sp,
                        textAlign = TextAlign.Center,
                    )
                }
            }
            drawerItem.forEach {
                NavigationDrawerItem(label = { Text(text = it.title) },
                    selected = it == selectedItem,
                    onClick = {
                        selectedItem = it

                        scope.launch {
                            drawerState.close()
                        }
                    },
                    icon = {
                        Icon(
                            painter = painterResource(id = it.icon),
                            contentDescription = it.title,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                )
            }
        }
    }, drawerState = drawerState) {
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
                                .background(color = colorResource(id = R.color.icon_bg))
                                .padding(10.dp)
                                .size(24.dp)
                                .clickable {
                                    scope.launch {
                                        drawerState.open()
                                    }
                                }
                        )
                        Image(
                            painter = painterResource(id = R.drawable.ic_search),
                            contentDescription = "",
                            modifier = Modifier
                                .padding(12.dp, 0.dp, 0.dp, 0.dp)
                                .clip(shape = CircleShape)
                                .background(color = colorResource(id = R.color.icon_bg))
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
                            .background(color = colorResource(id = R.color.icon_bg))
                            .padding(10.dp)
                            .size(24.dp)
                            .clickable {
                                navigator.navigate(MyBookingsDestination)
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
                                Image(
                                    painter = images[index],
                                    contentDescription = "Carousel Images"
                                )
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
                            navigator.navigate(BookingScreenFirstDestination)
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
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


}