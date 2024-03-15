package com.thezayin.kainaclean.home.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
    Box(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding()
            .background(color = colorResource(R.color.background))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()

                .padding(horizontal = 20.dp),
        ) {
            HomeTopBar(modifier = Modifier.weight(0.11f))
            HomeImageSlider(modifier = Modifier.weight(0.3f))
            HomeIcons(
                homeViewModel = homeViewModel,
                modifier = Modifier.weight(0.4f),
                navigator = navigator
            )
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(0.2f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom
            ) {
                HomeBottomNav(navigator = navigator, modifier = Modifier)
            }
        }
    }
}