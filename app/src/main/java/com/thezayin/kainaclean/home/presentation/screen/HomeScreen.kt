package com.thezayin.kainaclean.home.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.thezayin.kainaclean.R
import com.thezayin.kainaclean.home.presentation.component.HomeBottomNav
import com.thezayin.kainaclean.home.presentation.component.HomeIcons
import com.thezayin.kainaclean.home.presentation.component.HomeImageSlider
import com.thezayin.kainaclean.home.presentation.component.HomeTopBar
import com.thezayin.kainaclean.home.presentation.viewmodel.HomeViewModel

@Destination
@Composable
fun HomeScreen(
    navigator: DestinationsNavigator
) {
    val homeViewModel: HomeViewModel = hiltViewModel()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(horizontal = 20.dp)
            .navigationBarsPadding()
            .background(color = colorResource(R.color.background)),
    ) {
        HomeTopBar()
        HomeImageSlider(modifier = Modifier)
        HomeIcons(homeViewModel = homeViewModel, modifier = Modifier)

        Column(
            modifier = Modifier.fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {
            HomeBottomNav(navigator = navigator, modifier = Modifier)
        }
    }
}
