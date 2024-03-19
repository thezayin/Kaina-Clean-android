package com.thezayin.kainaclean.services.presentation.screens.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thezayin.kainaclean.R
import com.thezayin.kainaclean.services.presentation.viewmodel.ServiceOptionsViewModel

@SuppressLint("UnrememberedMutableState")
@Composable
fun ServicesComponent(serviceViewModel: ServiceOptionsViewModel, modifier: Modifier) {
    val services = remember {
        serviceViewModel.getServiceState.list
    }
    val state = rememberLazyListState()

    val serviceDataState = remember {
        ServiceOptionsViewModel.ServiceDataState()
    }
    serviceDataState.setNewList(services)

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
                fontFamily = FontFamily(Font(R.font.noto_sans_bold)),
                fontWeight = FontWeight.Medium,
            )
            Text(
                text = "*",
                textAlign = TextAlign.Center,
                color = colorResource(id = R.color.red),
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.noto_sans_bold)),
                fontWeight = FontWeight.Medium,
            )
        }

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp), state = state
        ) {
            items(serviceDataState.service, key = { it.id }) { item ->
                ServiceCards(
                    options = item,
                    modifier = Modifier,
                    onItemClick = serviceDataState::itemSelected
                )
            }
        }
    }
}
