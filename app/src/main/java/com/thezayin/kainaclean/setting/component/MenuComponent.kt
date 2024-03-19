package com.thezayin.kainaclean.setting.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thezayin.kainaclean.R

@Preview
@Composable
fun MenuComponent() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 45.dp, top = 45.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 35.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_list_privacy),
                contentDescription = null,
                modifier = Modifier
                    .padding(8.dp)
                    .size(22.dp)
            )
            Text(
                text = "Privacy Policy",
                modifier = Modifier.padding(start = 5.dp),
                textAlign = TextAlign.Center,
                color = colorResource(id = R.color.white),
                fontSize = 14.sp,
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 35.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_email),
                contentDescription = null,
                modifier = Modifier
                    .padding(8.dp)
                    .size(22.dp)
            )
            Text(
                text = "Contact us",
                modifier = Modifier.padding(start = 5.dp),
                textAlign = TextAlign.Center,
                color = colorResource(id = R.color.white),
                fontSize = 14.sp,
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 35.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_icon),
                contentDescription = null,
                modifier = Modifier
                    .padding(8.dp)
                    .size(22.dp)
            )
            Text(
                text = "Feed Back",
                modifier = Modifier.padding(start = 5.dp),
                textAlign = TextAlign.Center,
                color = colorResource(id = R.color.white),
                fontSize = 14.sp,
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 35.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_icon),
                contentDescription = null,
                modifier = Modifier
                    .padding(8.dp)
                    .size(22.dp)
            )
            Text(
                text = "Log out",
                modifier = Modifier.padding(start = 5.dp),
                textAlign = TextAlign.Center,
                color = colorResource(id = R.color.white),
                fontSize = 14.sp,
            )
        }
    }
}