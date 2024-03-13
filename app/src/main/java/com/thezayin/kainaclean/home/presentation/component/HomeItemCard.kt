package com.thezayin.kainaclean.home.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thezayin.kainaclean.R
import com.thezayin.kainaclean.home.domain.model.Home

@Composable
fun HomeItemCard(home: Home, modifier: Modifier) {
    Card(
        modifier = modifier.padding(
            start = 8.dp,
            end = 8.dp,
            top = 8.dp,
            bottom = 8.dp,
        ),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.background),
        ),
        elevation = CardDefaults.cardElevation(3.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = home.icon),
                contentDescription = null,
                modifier = Modifier
                    .padding(
                        vertical = 5.dp
                    ).padding(10.dp)
                    .size(80.dp),
                alignment = Alignment.Center
            )

            Text(
                text = home.title,
                modifier = Modifier
                    .padding(bottom = 20.dp)
                    .widthIn(60.dp)
                    .fillMaxWidth(),
                fontSize = 14.sp,
                color = colorResource(id = R.color.black),
                textAlign = TextAlign.Center
            )
        }
    }
}