package com.thezayin.kainaclean.home.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.thezayin.kainaclean.R
import com.thezayin.kainaclean.destinations.AddEstimateScreenDestination
import com.thezayin.kainaclean.destinations.EstimateHistoryScreenDestination
import com.thezayin.kainaclean.destinations.QuoteHistoryScreenDestination
import com.thezayin.kainaclean.destinations.QuoteScreenDestination
import com.thezayin.kainaclean.home.presentation.viewmodel.HomeViewModel
import com.thezayin.kainaclean.util.Response

@Composable
fun HomeMenuIcons(
    homeViewModel: HomeViewModel,
    modifier: Modifier,
    navigator: DestinationsNavigator
) {
    val state = homeViewModel.getHomeState.list
    Scaffold(
        modifier = modifier
            .background(color = colorResource(R.color.background)),
        containerColor = colorResource(
            id = R.color.background
        ),
        topBar = {},
        bottomBar = {}
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .wrapContentHeight()
                .background(color = colorResource(R.color.background))
        ) {
            when (state) {
                is Response.Loading -> {
                    // Loading
                }

                is Response.Failure -> {
                    Text(
                        text = "Unable to load data",
                        modifier = Modifier.fillMaxSize(),
                        textAlign = TextAlign.Center
                    )
                }

                is Response.Success -> {
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(2),
                        modifier = Modifier
                            .background(color = colorResource(R.color.background))
                            .fillMaxWidth()
                            .padding(bottom = 18.dp, top = 10.dp)
                    ) {
                        items(state.data.size) { item ->
                            HomeItemCard(
                                state.data[item],
                                modifier = Modifier,
                                onItemClick = { selected ->
                                    when (selected.title) {
                                        "Request Quote" -> {
                                            navigator.navigate(QuoteScreenDestination)
                                        }

                                        "Request Estimate" -> {
                                            navigator.navigate(AddEstimateScreenDestination)
                                        }

                                        "Services" -> {
                                            //                                        navigator.navigate("services")
                                        }

                                        "Quote History" -> {
                                            navigator.navigate(QuoteHistoryScreenDestination)
                                        }

                                        "Estimate History" -> {
                                            navigator.navigate(EstimateHistoryScreenDestination)
                                        }

                                        "Pricing" -> {
                                            //                                        navigator.navigate("pricing")
                                        }
                                    }

                                })
                        }
                    }
                }
            }
        }
    }
}
