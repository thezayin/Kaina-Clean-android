package com.thezayin.kainaclean.home.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.thezayin.kainaclean.R
import com.thezayin.kainaclean.destinations.QuoteScreenDestination
import com.thezayin.kainaclean.home.presentation.viewmodel.HomeViewModel
import com.thezayin.kainaclean.util.Response

@Composable
fun HomeIcons(homeViewModel: HomeViewModel, modifier: Modifier, navigator: DestinationsNavigator) {
    val state = homeViewModel.getHomeState.list
    Scaffold(
        modifier = modifier
            .background(color = colorResource(R.color.background))
            .heightIn(max = 400.dp),
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
                    Text(text = "Unable to load data", modifier = Modifier.fillMaxWidth())
                }

                is Response.Success -> {
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(2),
                        modifier = Modifier
                            .background(color = colorResource(R.color.background))
                            .fillMaxWidth()
                            .heightIn(max = 400.dp)
                    ) {
                        items(state.data.size) { item ->
                            HomeItemCard(state.data[item], modifier = Modifier.clickable {
                                if (state.data[item].title == "Quote") {
                                    navigator.navigate(QuoteScreenDestination)
                                }
                            })
                        }
                    }
                }
            }
        }
    }
}
