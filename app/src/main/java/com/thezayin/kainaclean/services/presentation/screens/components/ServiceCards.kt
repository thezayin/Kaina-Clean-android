package com.thezayin.kainaclean.services.presentation.screens.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.thezayin.kainaclean.R
import com.thezayin.kainaclean.services.domain.model.ServiceOptions
import com.thezayin.kainaclean.services.presentation.viewmodel.ServiceOptionsViewModel

@Composable
fun ServiceCards(
    options: ServiceOptions,
    modifier: Modifier,
    onItemClick: (ServiceOptions) -> Unit,
) {

    val viewModel: ServiceOptionsViewModel = hiltViewModel()
    Card(
        modifier = modifier
            .padding(
                start = 8.dp,
                end = 8.dp,
                top = 2.dp,
                bottom = 2.dp,
            )
            .width(115.dp)
            .height(if (options.isSelected == true) 150.dp else 140.dp)
            .clickable {
                onItemClick(
                    options.copy(
                        isSelected = options.isSelected?.not()
                    )
                )
                viewModel.selectedService = options.name!!
                viewModel.details = options.details!!
            },
        colors = CardDefaults.cardColors(
            containerColor = if (options.isSelected == true) colorResource(id = R.color.btn_primary) else colorResource(
                id = R.color.white
            ),
        ),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Card(
                    modifier = Modifier.size(50.dp),
                    shape = CircleShape,
                    colors = CardDefaults.cardColors(
                        containerColor = colorResource(id = R.color.white)
                    )
                ) {
                    Box(modifier = Modifier.fillMaxSize()) {
                        Image(
                            painter = painterResource(id = options.icon!!),
                            contentDescription = null,
                            alignment = Alignment.Center,
                            modifier = Modifier
                                .size(35.dp)
                                .align(Alignment.Center),
                            contentScale = ContentScale.Fit
                        )
                    }

                }
                Text(
                    text = options.name!!,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 10.dp, top = 10.dp)
                        .align(Alignment.CenterHorizontally)
                        .padding(horizontal = 10.dp),
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.noto_sans_regular)),
                    color = if (options.isSelected == true) colorResource(id = R.color.white) else colorResource(
                        id = R.color.black
                    ),
                    textAlign = TextAlign.Center,
                )
            }
        }
    }
}