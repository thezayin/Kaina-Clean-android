package com.thezayin.kainaclean.home.presentation.component.drawer

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thezayin.kainaclean.R

@Preview
@Composable
fun SideDrawer() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.btn_primary)),
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(0.5f),
                horizontalAlignment = Alignment.Start
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth()
                        .padding(vertical = 45.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Card(
                        modifier = Modifier.size(55.dp),
                        shape = RoundedCornerShape(55.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = colorResource(id = R.color.transparent)
                        )
                    ) {
                        Image(
                            modifier = Modifier.size(55.dp),
                            painter = painterResource(id = R.drawable.ic_quote),
                            contentDescription = null,
                            contentScale = ContentScale.Crop
                        )
                    }
                    Text(
                        text = "zainshahidbutt@gmail.com",
                        fontSize = 16.sp,
                        color = colorResource(
                            id = R.color.white
                        ),
                        modifier = Modifier.widthIn(max = 150.dp),
                        textAlign = TextAlign.Center
                    )
                    Spacer(
                        modifier = Modifier
                            .height(2.dp)
                            .background(color = colorResource(id = R.color.white))
                            .fillMaxWidth()
                            .padding(vertical = 40.dp)
                    )
                }
            }
            Card(
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .fillMaxHeight()
                    .padding(vertical = 85.dp),
                shape = RoundedCornerShape(topStart = 24.dp, bottomStart = 24.dp),

                ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_quote),
                    contentDescription = null
                )
            }

        }
    }
}