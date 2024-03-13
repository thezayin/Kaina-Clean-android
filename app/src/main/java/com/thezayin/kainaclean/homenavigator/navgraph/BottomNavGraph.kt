package com.thezayin.kainaclean.homenavigator.navgraph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.thezayin.kainaclean.homenavigator.bottom.BottomBarScreen


@Composable
fun BottomNavGraph(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = BottomBarScreen.Home.route) {
        composable(route = BottomBarScreen.Home.route) {

        }
        composable(route = BottomBarScreen.Booking.route) {

        }
        composable(route = BottomBarScreen.Calender.route) {

        }
    }

}