package com.thezayin.kainaclean.presentation.auth.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.thezayin.kainaclean.R
import com.thezayin.kainaclean.presentation.auth.AuthViewModel
import com.thezayin.kainaclean.presentation.destinations.ForgetPasswordScreenDestination
import com.thezayin.kainaclean.presentation.destinations.HomeScreenDestination
import com.thezayin.kainaclean.presentation.destinations.SignUpScreenDestination
import com.thezayin.kainaclean.presentation.toast.Toast
import com.thezayin.kainaclean.util.Response


@OptIn(ExperimentalMaterial3Api::class)
@Destination
@Composable
fun LoginScreen(
    navigator: DestinationsNavigator
) {

    val authViewModel: AuthViewModel = hiltViewModel()

    val emailInputValue = remember { mutableStateOf("") }
    val passwordNumberInputValue = remember { mutableStateOf("") }

    val email = remember {
        mutableStateOf("")
    }

    val password = remember {
        mutableStateOf("")
    }

    val error = remember {
        mutableStateOf("")
    }

    val isBottomSheetShow = rememberSaveable {
        mutableStateOf(false)
    }

    val sheetState = rememberModalBottomSheetState()

    val scope = rememberCoroutineScope()

    if (isBottomSheetShow.value) {
        ModalBottomSheet(
            sheetState = sheetState,
            onDismissRequest = {
                isBottomSheetShow.value = false
            },
            containerColor = colorResource(id = R.color.background),
            modifier = Modifier.padding(10.dp, 0.dp, 10.dp, 40.dp),
            shape = RoundedCornerShape(30.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = colorResource(id = R.color.background))
                    .fillMaxWidth()
            ) {
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                    Image(painter = painterResource(id = R.drawable.ic_close_circle),
                        contentDescription = "",
                        modifier = Modifier
                            .padding(horizontal = 20.dp)
                            .size(25.dp)
                            .clickable {
                                isBottomSheetShow.value = false
                            })
                }

                Row(
                    modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_alert),
                        contentDescription = "",
                        modifier = Modifier.size(65.dp)
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = error.value,
                        fontSize = 22.sp,
                        color = colorResource(id = R.color.text_color),
                        modifier = Modifier.padding(0.dp, 30.dp, 0.dp, 50.dp)
                    )

                }
            }

        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.background))
            .statusBarsPadding()
    ) {
        Column(
            modifier = Modifier
                .statusBarsPadding()
                .fillMaxSize()
                .padding(horizontal = 20.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_icon),
                contentDescription = null,
                modifier = Modifier.size(100.dp)
            )
            Text(
                text = "Hi there!",
                color = colorResource(id = R.color.text_color),
                fontSize = 35.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif,
                modifier = Modifier.fillMaxWidth()

            )
            TextField(
                value = emailInputValue.value,
                onValueChange = { emailInputValue.value = it },
                placeholder = {
                    Text(text = "Enter your Email")
                },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 10.dp, 0.dp, 0.dp),
                shape = RoundedCornerShape(8.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = colorResource(id = R.color.ed_background),
                    unfocusedContainerColor = colorResource(id = R.color.ed_background),
                    disabledLabelColor = colorResource(id = R.color.red),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )
            TextField(
                value = passwordNumberInputValue.value,
                onValueChange = { passwordNumberInputValue.value = it },
                placeholder = {
                    Text(text = "Enter your Password")
                },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 20.dp, 0.dp, 20.dp),
                shape = RoundedCornerShape(8.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = colorResource(id = R.color.ed_background),
                    unfocusedContainerColor = colorResource(id = R.color.ed_background),
                    disabledLabelColor = colorResource(id = R.color.red),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 5.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "SignUp",
                    fontSize = 13.sp,
                    color = colorResource(id = R.color.text_color),
                    modifier = Modifier.clickable {
                        navigator.navigate(SignUpScreenDestination)
                    })

                Text(text = "Forgot Password?",
                    fontSize = 13.sp,
                    color = colorResource(id = R.color.text_color),
                    modifier = Modifier.clickable {
                        navigator.navigate(ForgetPasswordScreenDestination)
                    })
            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp, 0.dp, 20.dp, 40.dp),
            verticalArrangement = Arrangement.Bottom
        ) {
            Button(
                onClick = {
                    authViewModel.signIn(
                        email = emailInputValue.value,
                        password = passwordNumberInputValue.value
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.btn_primary),
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(12.dp),

                ) {
                Text(
                    text = "Sign in", color = colorResource(id = R.color.white), fontSize = 20.sp
                )

                when (val response = authViewModel.signInState.value) {
                    is Response.Loading -> {
                        CircularProgressIndicator(
                            modifier = Modifier.fillMaxSize()
                        )
                    }

                    is Response.Success -> {
                        if (response.data) {
                            navigator.navigate(HomeScreenDestination)
                        } else {
Toast(message = "Unknown Error")
                        }
                    }

                    is Response.Error -> {
                        Toast(message = response.message)
                    }
                }
            }
        }
    }
}