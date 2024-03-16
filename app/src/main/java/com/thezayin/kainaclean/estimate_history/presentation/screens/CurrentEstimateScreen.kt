package com.thezayin.kainaclean.estimate_history.presentation.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.thezayin.kainaclean.R
import com.thezayin.kainaclean.estimate_history.presentation.screens.component.EstimateCurrentCard
import com.thezayin.kainaclean.estimate_history.presentation.viewmodel.EstimateHistoryViewModel
import com.thezayin.kainaclean.main.component.TopBar
import com.thezayin.kainaclean.main.component.dialogs.LoadingDialog
import com.thezayin.kainaclean.util.Response
import com.thezayin.kainaclean.util.checkForInternet

@Destination
@Composable
fun CurrentEstimateScreen(
    navigator: DestinationsNavigator,
    estimateId: String
) {
    val viewModel: EstimateHistoryViewModel = hiltViewModel()
    val estimateUiState = viewModel.getCurrentEstimate
    val context = LocalContext.current
    var checkNetwork by remember { mutableStateOf(false) }
    val showProgressBar = remember { mutableStateOf(false) }

    if (!checkForInternet(context)) {
        checkNetwork = true

    }

    if (showProgressBar.value) {
        LoadingDialog()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding()
            .background(color = colorResource(id = R.color.background))
    ) {
        TopBar(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .padding(top = 20.dp),
            title = "Estimate Details"
        ) {
            navigator.navigateUp()
        }
        when (estimateUiState.estimateList) {
            is Response.Loading -> {
                showProgressBar.value = true
                viewModel.getCurrentEstimate(estimateId)
            }

            is Response.Failure -> {
                showProgressBar.value = false
                Toast.makeText(
                    context,
                    "Error: ${estimateUiState.estimateList.e}",
                    Toast.LENGTH_LONG
                ).show()
            }

            is Response.Success -> {
                showProgressBar.value = false
                EstimateCurrentCard(estimateUiState.estimateList.data)
            }
        }
    }
}