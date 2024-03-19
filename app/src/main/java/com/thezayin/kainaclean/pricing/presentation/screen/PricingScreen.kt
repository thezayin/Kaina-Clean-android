package com.thezayin.kainaclean.pricing.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.thezayin.kainaclean.R
import com.thezayin.kainaclean.main.component.TopBar
import com.thezayin.kainaclean.pricing.presentation.screen.component.PricingDetailsCard
import com.thezayin.kainaclean.pricing.presentation.viewmodel.PricingViewModel

@Composable
@Destination
fun PricingScreen(
    navigator: DestinationsNavigator
) {
    val viewModel: PricingViewModel = hiltViewModel()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.background))
            .statusBarsPadding()
    ) {

        Column(
            modifier = Modifier
                .padding(top = 25.dp)
                .background(color = colorResource(id = R.color.background))
        ) {
            TopBar(
                modifier = Modifier
                    .padding(horizontal = 20.dp),
                title = "Pricing",
                callBack = { navigator.navigateUp() }
            )
            PricingDetailsCard(viewModel = viewModel, modifier = Modifier)
        }
    }
}