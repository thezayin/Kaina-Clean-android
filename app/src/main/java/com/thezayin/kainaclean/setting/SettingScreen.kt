package com.thezayin.kainaclean.setting

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.thezayin.kainaclean.R
import com.thezayin.kainaclean.setting.component.InfoComponent
import com.thezayin.kainaclean.setting.component.MenuComponent

@Preview
@Composable
fun SettingScreen(

) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .navigationBarsPadding()
            .background(color = colorResource(id = R.color.btn_primary))
    ) {

        InfoComponent(email = "zainshaidbuttt@gamil.com")
        MenuComponent()
    }
}