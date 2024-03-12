package com.thezayin.kainaclean.presentation.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.thezayin.kainaclean.R
import com.thezayin.kainaclean.presentation.auth.presentation.viewmodel.AuthViewModel
import com.thezayin.kainaclean.presentation.destinations.HomeScreenDestination
import com.thezayin.kainaclean.presentation.destinations.LoginScreenDestination
import com.thezayin.kainaclean.util.checkForInternet

@Composable
@Destination(start = true)
fun OnBoardingScreen(
    navigator: DestinationsNavigator
) {

    val authViewModel: AuthViewModel = hiltViewModel()
    var isClicked by remember { mutableStateOf(false) }
    var checkNetwork by remember { mutableStateOf(false) }
    val context = LocalContext.current

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.ic_onboarding),
            contentDescription = "",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        colorResource(id = R.color.color_starting),
                        colorResource(id = R.color.color_starting),
                        colorResource(id = R.color.color_mid),
                        colorResource(id = R.color.color_end)
                    )
                )
            ),
        verticalArrangement = Arrangement.Bottom,
    ) {

        Text(
            text = "Kaina Cleaner",
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.white),
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = "The Best Cleaning Service Ever!",
            fontSize = 24.sp,
            color = colorResource(id = R.color.white),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 27.dp)
        )
        Button(
            onClick = {
                if (checkForInternet(context)) {
                    isClicked = true
                    checkNetwork = false
                } else {
                    checkNetwork = true
                }

            },
            modifier = Modifier
                .padding(24.dp, 44.dp)
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.onboarding_btn),
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(size = 6.dp)
        ) {
            Text(
                text = "Get Started", fontSize = 16.sp,
                color = colorResource(id = R.color.white),
                textAlign = TextAlign.Center,
            )
        }
    }
    if (isClicked) {
        AuthState(navigator = navigator, authViewModel = authViewModel)
    }

    if (checkNetwork) {
        Dialog(onDismissRequest = {
            checkNetwork = false
        }) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(16.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = colorResource(id = R.color.white),
                )

            ) {
                Column(modifier = Modifier.fillMaxSize()) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "No InternetConnection",
                            fontSize = 16.sp,
                            color = colorResource(id = R.color.text_color)
                        )
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(20.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_connection),
                            contentDescription = ""
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun AuthState(
    navigator: DestinationsNavigator,
    authViewModel: AuthViewModel
) {
    if (authViewModel.isUserAuthenticated) {
        navigator.navigate(HomeScreenDestination)
    } else {
        navigator.navigate(LoginScreenDestination)
    }
}

