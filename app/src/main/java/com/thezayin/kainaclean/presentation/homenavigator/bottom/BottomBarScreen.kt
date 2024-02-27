package com.thezayin.kainaclean.presentation.homenavigator.bottom

import com.thezayin.kainaclean.R

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: Int
) {
    object Home : BottomBarScreen(
        route = "home",
        title = "Home",
        icon = R.drawable.ic_home
    )

    object Booking : BottomBarScreen(
        route = "booking",
        title = "Booking",
        icon = R.drawable.ic_booking
    )

    object Calender : BottomBarScreen(
        route = "calender",
        title = "Calender",
        icon = R.drawable.ic_calender
    )
}