package com.thezayin.kainaclean.setting

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.thezayin.kainaclean.R
import com.thezayin.kainaclean.auth.presentation.viewmodel.AuthViewModel
import com.thezayin.kainaclean.setting.component.InfoComponent
import com.thezayin.kainaclean.setting.component.MenuComponent

@Destination
@Composable
fun SettingScreen(
    navigator: DestinationsNavigator
) {
    val context = LocalContext.current
    val viewModel: AuthViewModel = hiltViewModel()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.btn_primary))
    ) {

        InfoComponent(email = "zainshaidbuttt@gamil.com")
        MenuComponent(viewModel = viewModel, navigator = navigator, context = context)
    }
}