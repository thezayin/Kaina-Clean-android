package com.thezayin.kainaclean.services.presentation.screens.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thezayin.kainaclean.R
import com.thezayin.kainaclean.services.presentation.viewmodel.ServiceOptionsViewModel


@Composable
fun ServiceDetailsCard(viewModel: ServiceOptionsViewModel) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(25.dp),
        shape = RoundedCornerShape(4.dp),
        colors = CardDefaults.cardColors(
            colorResource(id = R.color.background)
        ),
        border = BorderStroke(1.dp, colorResource(id = R.color.grey_level_5))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp, vertical = 20.dp)
        ) {
            Text(
                text = "Details",
                color = colorResource(id = R.color.black),
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.noto_sans_medium)),
            )
            Text(
                text = viewModel.details, color = colorResource(id = R.color.grey),
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.noto_sans_medium)),
                textAlign = TextAlign.Start
            )
        }
    }
}