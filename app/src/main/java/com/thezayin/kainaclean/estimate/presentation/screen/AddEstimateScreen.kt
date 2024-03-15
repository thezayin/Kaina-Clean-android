package com.thezayin.kainaclean.estimate.presentation.screen

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.thezayin.kainaclean.estimate.presentation.viewmodel.AddEstimateViewModel

@Composable
@Destination
fun AddEstimateScreen(
    navigator: DestinationsNavigator
) {
    val viewModel: AddEstimateViewModel = hiltViewModel()


}