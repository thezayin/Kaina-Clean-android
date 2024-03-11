package com.thezayin.kainaclean.presentation.chatbot.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thezayin.kainaclean.R

@Composable
fun TopBar(modifier: Modifier, title: String, callBack: () -> Unit) {
    Box(
        modifier = modifier
            .background(colorResource(id = R.color.white))
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        Image(painter = painterResource(id = R.drawable.ic_back),
            contentDescription = "",
            modifier = Modifier
                .size(22.dp)
                .fillMaxHeight()
                .align(Alignment.CenterStart)
                .clickable {
                    callBack()
                })
        Text(
            text = title,
            fontSize = 24.sp,
            color = colorResource(id = R.color.text_color),
            fontWeight = FontWeight.Medium,
            fontFamily = FontFamily(Font(R.font.nunito_extrabold)),
            modifier = Modifier
                .align(alignment = Alignment.Center)

        )
    }
}