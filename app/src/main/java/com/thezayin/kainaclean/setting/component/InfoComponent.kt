package com.thezayin.kainaclean.setting.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.thezayin.kainaclean.R

@Composable
fun InfoComponent(email: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 45.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Card(
                modifier = Modifier
                    .size(56.dp)
                    .align(Alignment.CenterHorizontally),
                shape = RoundedCornerShape(150.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_icon),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(8.dp)
                        .align(Alignment.CenterHorizontally),
                    contentScale = ContentScale.Crop,
                    alignment = Alignment.BottomCenter
                )
            }
            Text(
                text = email,
                textAlign = TextAlign.Center,
                color = colorResource(
                    id = R.color.white
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .widthIn(300.dp)
                    .padding(top = 15.dp)
            )
            Spacer(
                modifier = Modifier
                    .padding(horizontal = 56.dp)
                    .padding(top = 25.dp)
                    .height(2.dp)
                    .fillMaxWidth()
                    .background(color = colorResource(id = R.color.white))

            )
        }
    }
}