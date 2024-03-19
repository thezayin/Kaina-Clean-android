package com.thezayin.kainaclean.pricing.presentation.screen.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.thezayin.kainaclean.pricing.presentation.screen.state.CommercialDataState
import com.thezayin.kainaclean.pricing.presentation.screen.state.DomesticDataState
import com.thezayin.kainaclean.pricing.presentation.screen.state.PropertyDataState
import com.thezayin.kainaclean.pricing.presentation.viewmodel.PricingViewModel

@Composable
fun PricingDetailsCard(
    viewModel: PricingViewModel, modifier: Modifier
) {
    val analytics = viewModel.analytics
    val propertyList = remember {
        viewModel.getPropertyType.list
    }

    val domesticList = remember {
        viewModel.getDomesticType.list
    }

    val commercialList = remember {
        viewModel.getCommercialType.list
    }

    val state = rememberLazyListState()

    val propertyState = remember {
        PropertyDataState()
    }

    val domesticState = remember {
        DomesticDataState()
    }

    val commercialState = remember {
        CommercialDataState()
    }

    propertyState.setNewPropertyList(propertyList)
    domesticState.setNewDomesticList(domesticList)
    commercialState.setNewCommercialList(commercialList)

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 50.dp)
            .padding(horizontal = 25.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        LazyRow(
            modifier = Modifier, state = state
        ) {
            items(propertyState.property, key = { it.id }) { item ->
                PropertyList(
                    propertyType = item,
                    modifier = Modifier,
                    analytics = analytics,
                    onItemClick = propertyState::itemSelected
                )
            }
        }

        if (viewModel.selectedProperty == "Domestic") {
            LazyRow(modifier = Modifier) {
                items(domesticState.domestic, key = { it.id }) { item ->
                    DomesticServicesCard(
                        options = item,
                        modifier = Modifier,
                        analytics = analytics,
                        onItemClick = domesticState::itemSelected
                    )
                }
            }
        } else if (viewModel.selectedProperty == "Commercial") {
            LazyRow(modifier = Modifier) {
                items(commercialState.commercial, key = { it.id }) { item ->
                    CommercialServicesCard(
                        options = item,
                        modifier = Modifier,
                        analytics = analytics,
                        onItemClick = commercialState::itemSelected
                    )
                }
            }

        }
        PricingCard(viewModel.price)
    }
}


