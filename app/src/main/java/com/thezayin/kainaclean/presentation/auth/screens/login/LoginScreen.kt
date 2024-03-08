package com.thezayin.kainaclean.presentation.auth.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.PasswordVisualTransformation
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
import com.thezayin.kainaclean.util.Response.Failure
import com.thezayin.kainaclean.util.Response.Loading
import com.thezayin.kainaclean.util.Response.Success
import com.thezayin.kainaclean.util.Utils

@OptIn(ExperimentalMaterial3Api::class)
@Destination
@Composable
fun LoginScreen(
    navigator: DestinationsNavigator
) {
    val authViewModel: AuthViewModel = hiltViewModel()
    val emailState = remember { mutableStateOf("") }
    val passwordState = remember { mutableStateOf("") }
    val showProgressBar = remember { mutableStateOf(false) }

    if (showProgressBar.value) {
        Box(modifier = Modifier.fillMaxSize())
        CircularProgressIndicator(
            modifier = Modifier
                .size(100.dp),
            color = colorResource(id = R.color.btn_primary)
        )
    }

    val isBottomSheetShow = rememberSaveable {
        mutableStateOf(false)
    }
    val sheetState = rememberModalBottomSheetState()
    if (isBottomSheetShow.value) {
        ModalBottomSheet(
            sheetState = sheetState,
            onDismissRequest = {
                isBottomSheetShow.value = false
            },
            dragHandle = null,
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
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 40.dp, bottom = 20.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .size(70.dp),
                        color = colorResource(id = R.color.btn_primary)
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Loading",
                        fontSize = 22.sp,
                        color = colorResource(id = R.color.text_color),
                        modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 50.dp)
                    )
                }
            }
        }
    }
    Image(
        painter = painterResource(id = R.drawable.ic_login_bg),
        contentDescription = null,
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
    ) {
        Row(
            modifier = Modifier
                .fillMaxHeight(0.4f)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_icon),
                contentDescription = null,
                modifier = Modifier.size(150.dp)
            )
        }

        Column(
            modifier = Modifier
                .statusBarsPadding()
                .fillMaxWidth()
                .fillMaxHeight(0.6f)
                .padding(horizontal = 20.dp),
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = "Email",
                color = colorResource(id = R.color.white),
                fontSize = 16.sp,
                fontFamily = FontFamily.SansSerif,
                modifier = Modifier.fillMaxWidth()

            )
            OutlinedTextField(
                value = emailState.value,
                trailingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_mail),
                        contentDescription = null,
                        tint = colorResource(id = R.color.white)
                    )
                },
                onValueChange = { emailState.value = it },
                placeholder = {
                    Text(
                        text = "Enter your Email",
                        fontSize = 16.sp,
                        color = colorResource(id = R.color.white)
                    )
                },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp),
                shape = RoundedCornerShape(8.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = colorResource(id = R.color.transparent),
                    unfocusedContainerColor = colorResource(id = R.color.transparent),
                    disabledLabelColor = colorResource(id = R.color.red),
                    focusedBorderColor = colorResource(id = R.color.white),

                    )
            )
            Text(
                text = "Password",
                color = colorResource(id = R.color.white),
                fontSize = 16.sp,
                fontFamily = FontFamily.SansSerif,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)

            )
            OutlinedTextField(
                value = passwordState.value,
                onValueChange = { passwordState.value = it },
                placeholder = {
                    Text(
                        text = "Enter your Password",
                        fontSize = 16.sp,
                        color = colorResource(id = R.color.white)
                    )
                },
                trailingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_lock),
                        contentDescription = null,
                        tint = colorResource(id = R.color.white)
                    )
                },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp),
                shape = RoundedCornerShape(8.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = colorResource(id = R.color.transparent),
                    unfocusedContainerColor = colorResource(id = R.color.transparent),
                    disabledLabelColor = colorResource(id = R.color.red),
                    focusedBorderColor = colorResource(id = R.color.white),
                ),
                visualTransformation = PasswordVisualTransformation()
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 5.dp)
                    .padding(top = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "SignUp",
                    fontSize = 16.sp,
                    color = colorResource(id = R.color.white),
                    modifier = Modifier.clickable {
                        navigator.navigate(SignUpScreenDestination)
                    })

                Text(text = "Forgot Password?",
                    fontSize = 16.sp,
                    color = colorResource(id = R.color.white),
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
                    isBottomSheetShow.value = true
                    authViewModel.signIn(emailState.value, passwordState.value)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.onboarding_btn),
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(12.dp),

                ) {
                Text(
                    text = "Sign in", color = colorResource(id = R.color.white), fontSize = 16.sp
                )
                when (val signInResponse = authViewModel.signInState.value) {
                    is Loading -> {
                        isBottomSheetShow.value = true
                    }

                    is Success -> {
                        if (signInResponse.data) {
                            navigator.navigate(HomeScreenDestination)
                        }
                        isBottomSheetShow.value = false
                    }

                    is Failure -> signInResponse.apply {
                        isBottomSheetShow.value = false
                        Utils.print(e)
                        Toast(message = e)
                    }
                }
            }
        }
    }

}
