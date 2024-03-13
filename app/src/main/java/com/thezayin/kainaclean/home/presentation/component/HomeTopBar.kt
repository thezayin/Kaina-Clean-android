package com.thezayin.kainaclean.home.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.thezayin.kainaclean.R
import kotlinx.coroutines.launch

@Preview
@Composable
fun HomeTopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(painter = painterResource(id = R.drawable.ic_menu),
            contentDescription = "",
            modifier = Modifier
                .clip(shape = CircleShape)
                .background(color = colorResource(id = R.color.light_purple))
                .padding(10.dp)
                .size(24.dp)
                .clickable {

                })

        Image(
            painter = painterResource(id = R.drawable.ic_notifcation),
            contentDescription = "",
            modifier = Modifier
                .padding(12.dp, 0.dp, 0.dp, 0.dp)
                .clip(shape = CircleShape)
                .background(color = colorResource(id = R.color.light_purple))
                .padding(10.dp)
                .size(24.dp)
                .clickable {

                },
            alignment = Alignment.CenterEnd
        )
    }
}