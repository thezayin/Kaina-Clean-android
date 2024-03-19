package com.thezayin.kainaclean.onboarding

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.thezayin.kainaclean.R
import com.thezayin.kainaclean.destinations.LoginScreenDestination
import com.thezayin.kainaclean.destinations.SignUpScreenDestination
import com.thezayin.kainaclean.util.getActivity

@Destination
@Composable
fun OnBoardingScreen(
    navigator: DestinationsNavigator
) {
    val activity = LocalContext.current.getActivity()

    BackHandler() {
        activity?.finish()
    }

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
            fontFamily = FontFamily(Font(R.font.noto_sans_regular)),
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.white),
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = "The Best Cleaning Service Ever!",
            fontFamily = FontFamily(Font(R.font.noto_sans_regular)),
            fontSize = 24.sp,
            color = colorResource(id = R.color.white),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp)
                .padding(horizontal = 27.dp)
        )

        Button(
            onClick = {
                navigator.navigate(LoginScreenDestination)
            },
            modifier = Modifier
                .padding(horizontal = 24.dp)
                .padding(top = 38.dp)
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.btn_primary),
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(size = 56.dp)
        ) {
            Text(
                text = "Log In", fontSize = 16.sp,
                color = colorResource(id = R.color.white),
                textAlign = TextAlign.Center,
            )
        }

        Button(
            onClick = {
                navigator.navigate(SignUpScreenDestination)
            },
            modifier = Modifier
                .padding(horizontal = 24.dp)
                .fillMaxWidth()
                .padding(top = 15.dp, bottom = 44.dp)
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.onboarding_btn),
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(size = 56.dp)
        ) {
            Text(
                text = "Sign Up", fontSize = 16.sp,
                color = colorResource(id = R.color.white),
                textAlign = TextAlign.Center,
            )
        }
    }
}


