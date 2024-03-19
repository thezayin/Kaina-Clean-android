package com.thezayin.kainaclean.estimate_history.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.thezayin.kainaclean.R
import com.thezayin.kainaclean.destinations.CurrentEstimateScreenDestination
import com.thezayin.kainaclean.estimate_history.presentation.screens.component.EstimateCard
import com.thezayin.kainaclean.estimate_history.presentation.viewmodel.EstimateHistoryViewModel
import com.thezayin.kainaclean.main.component.TopBar
import com.thezayin.kainaclean.main.component.dialogs.LoadingDialog
import com.thezayin.kainaclean.main.component.dialogs.NetworkDialog
import com.thezayin.kainaclean.util.Constants
import com.thezayin.kainaclean.util.Response
import com.thezayin.kainaclean.util.Toast
import com.thezayin.kainaclean.util.checkForInternet

@Composable
@Destination
fun EstimateHistoryScreen(
    navigator: DestinationsNavigator
) {
    val viewMode: EstimateHistoryViewModel = hiltViewModel()
    val estimateUiState = viewMode.getAllEstimates
    val context = LocalContext.current
    val showProgressBar = remember { mutableStateOf(false) }
    var checkNetwork by remember { mutableStateOf(false) }
    if (!checkForInternet(context)) {
        checkNetwork = true
    }

    if (checkNetwork) {
        NetworkDialog(showDialog = { checkNetwork = it })
    }

    if (showProgressBar.value) {
        LoadingDialog()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.background))
            .statusBarsPadding()
            .navigationBarsPadding(),
    ) {
        Column(
            modifier = Modifier
                .background(color = colorResource(id = R.color.background))
                .fillMaxSize()

        ) {
            TopBar(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .padding(top = 20.dp),
                title = "Estimates History"
            ) {
                navigator.navigateUp()
            }

            Column(
                modifier = Modifier
                    .padding(Constants.HORIZONTAL_PADDING)
                    .padding(top = 20.dp)
                    .background(color = colorResource(id = R.color.background))
            ) {
                Text(
                    text = "Click on desired card to check details",
                    fontSize = Constants.TEXT_SUBTITLE,
                    fontFamily = FontFamily(Font(R.font.noto_sans_regular)),
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
                when (estimateUiState.estimateList) {
                    is Response.Failure -> {
                        showProgressBar.value = false
                        Toast(message = "UnExpected error please try again")
                    }

                    Response.Loading -> {
                        showProgressBar.value = true
                    }

                    is Response.Success -> {
                        showProgressBar.value = false
                        LazyColumn {
                            items(estimateUiState.estimateList.data.sortedBy { it.addedDate!!.toIntOrNull() }) { estimate ->
                                EstimateCard(estimate) {
                                    navigator.navigate(CurrentEstimateScreenDestination(estimate.estimateId!!))
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}