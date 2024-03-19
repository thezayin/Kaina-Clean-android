package com.thezayin.kainaclean.home.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thezayin.kainaclean.R
import com.thezayin.kainaclean.home.domain.model.Home

@Composable
fun HomeItemCard(home: Home, modifier: Modifier, onItemClick: (Home) -> Unit) {
    Card(
        modifier = modifier
            .height(180.dp)
            .width(100.dp)
            .padding(
                start = 8.dp,
                end = 8.dp,
                top = 8.dp,
                bottom = 8.dp,
            )
            .clickable {
                onItemClick(home)
            },
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.background),
        ),
        elevation = CardDefaults.cardElevation(5.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = home.icon),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(40.dp),
            )

            Text(
                text = home.title,
                modifier = Modifier
                    .padding(bottom = 30.dp)
                    .widthIn(60.dp)
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth(),
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.noto_sans_regular)),
                color = colorResource(id = R.color.black),
                textAlign = TextAlign.Center
            )
        }
    }
}