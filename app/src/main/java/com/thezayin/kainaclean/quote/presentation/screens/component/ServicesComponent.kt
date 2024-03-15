package com.thezayin.kainaclean.quote.presentation.screens.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thezayin.kainaclean.R
import com.thezayin.kainaclean.quote.presentation.viewmodel.ServiceOptionsViewModel
import com.thezayin.kainaclean.util.Response

@Composable
fun ServicesComponent(serviceViewModel: ServiceOptionsViewModel, modifier: Modifier) {
    val services = serviceViewModel.getServiceState.list
    Column(modifier = modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .padding(bottom = 5.dp)
        ) {
            Text(
                text = "Service Required",
                textAlign = TextAlign.Center,
                color = colorResource(id = R.color.text_color),
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.nunito_bold)),
                fontWeight = FontWeight.Medium,
            )
            Text(
                text = "*",
                textAlign = TextAlign.Center,
                color = colorResource(id = R.color.red),
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.nunito_bold)),
                fontWeight = FontWeight.Medium,
            )
        }
        when (services) {
            is Response.Success -> {
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                ) {
                    items(services.data.size) { item ->
                        ServiceCards(
                            options = services.data[item],
                            modifier = Modifier,
                            onItemClick = {serviceOptions ->
//                                          if (serviceOptions.selected) {
//                                              serviceViewModel.unSelectService(serviceOptions)
//                                          } else {
//                                              serviceViewModel.selectService(serviceOptions)
//                                          }
                            },
                            selected = false
                        )
                    }
                }
            }

            else -> {
                CircularProgressIndicator()
            }
        }
    }
}