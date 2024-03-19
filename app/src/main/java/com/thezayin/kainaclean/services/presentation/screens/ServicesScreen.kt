package com.thezayin.kainaclean.services.presentation.screens

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
import com.thezayin.kainaclean.services.presentation.screens.components.ServiceDetailsCard
import com.thezayin.kainaclean.services.presentation.screens.components.ServicesComponent
import com.thezayin.kainaclean.services.presentation.viewmodel.ServiceOptionsViewModel

@Destination
@Composable
fun ServicesScreen(
    navigator: DestinationsNavigator
) {
    val serviceViewModel: ServiceOptionsViewModel = hiltViewModel()
    val analytics = serviceViewModel.analytics
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
                title = "Services",
                callBack = { navigator.navigateUp() }
            )
            ServicesComponent(
                serviceViewModel = serviceViewModel,
                analytics = analytics,
                modifier = Modifier.padding(top = 30.dp)
            )
            ServiceDetailsCard(viewModel = serviceViewModel)
        }
    }
}
