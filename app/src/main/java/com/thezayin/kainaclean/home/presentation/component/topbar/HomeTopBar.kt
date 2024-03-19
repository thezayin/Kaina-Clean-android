package com.thezayin.kainaclean.home.presentation.component.topbar

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
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.thezayin.analytics.dependencies.Analytics
import com.thezayin.analytics.events.AnalyticsEvent
import com.thezayin.kainaclean.R
import com.thezayin.kainaclean.destinations.SettingScreenDestination

@Composable
fun HomeTopBar(modifier: Modifier, navigator: DestinationsNavigator, analytic: Analytics) {
    Row(
        modifier = modifier
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
                    navigator.navigate(SettingScreenDestination)
                    analytic.logEvent(AnalyticsEvent.SettingSelected("setting_selected"))
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