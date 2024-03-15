package com.thezayin.kainaclean.auth.presentation.screens.signup

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.thezayin.kainaclean.R
import com.thezayin.kainaclean.auth.presentation.viewmodel.AuthViewModel
import com.thezayin.kainaclean.destinations.HomeScreenDestination
import com.thezayin.kainaclean.util.Response.Failure
import com.thezayin.kainaclean.util.Response.Loading
import com.thezayin.kainaclean.util.Response.Success
import com.thezayin.kainaclean.util.Utils


@Destination
@Composable
fun SignUpScreen(navigator: DestinationsNavigator) {

    val authViewModel: AuthViewModel = hiltViewModel()
    val emailInputValue = remember { mutableStateOf("") }
    val passwordNumberInputValue = remember { mutableStateOf("") }
    val rePasswordValue = remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.background))
            .statusBarsPadding()
    ) {
        Row(
            modifier = Modifier
                .fillMaxHeight(0.4f)
                .fillMaxWidth()
                .padding(top = 40.dp, bottom = 20.dp)
                .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.Start
        ) {
            Image(painter = painterResource(id = R.drawable.ic_back),
                contentDescription = null,
                modifier = Modifier
                    .height(25.dp)
                    .width(25.dp)
                    .align(Alignment.Top)
                    .clickable {
                        navigator.navigateUp()
                    })

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_icon),
                    contentDescription = null,
                    modifier = Modifier.size(150.dp)
                )
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.6f)
                .padding(horizontal = 20.dp)
        ) {
            Text(
                text = "Email",
                color = colorResource(id = R.color.black),
                fontSize = 16.sp,
                fontFamily = FontFamily.SansSerif,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 5.dp)
            )

            OutlinedTextField(
                value = emailInputValue.value,
                onValueChange = { emailInputValue.value = it },
                placeholder = {
                    Text(
                        text = "Enter your Email",
                        color = colorResource(id = R.color.black),
                        fontSize = 16.sp,
                        fontFamily = FontFamily.SansSerif,
                    )
                },
                trailingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_mail),
                        contentDescription = null,
                        tint = colorResource(id = R.color.black)
                    )
                },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = colorResource(id = R.color.transparent),
                    unfocusedContainerColor = colorResource(id = R.color.transparent),
                    disabledLabelColor = colorResource(id = R.color.red),
                    focusedBorderColor = colorResource(id = R.color.black),
                    focusedTextColor = colorResource(id = R.color.black),
                    unfocusedTextColor = colorResource(id = R.color.black),
                )
            )

            Text(
                text = "Password",
                color = colorResource(id = R.color.black),
                fontSize = 16.sp,
                fontFamily = FontFamily.SansSerif,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp, bottom = 5.dp)

            )

            OutlinedTextField(
                value = passwordNumberInputValue.value,
                onValueChange = { passwordNumberInputValue.value = it },
                placeholder = {
                    Text(
                        text = "Enter your Password",
                        color = colorResource(id = R.color.black),
                        fontSize = 16.sp,
                        fontFamily = FontFamily.SansSerif,
                    )
                },
                trailingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_lock),
                        contentDescription = null,
                        tint = colorResource(id = R.color.black)
                    )
                },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = colorResource(id = R.color.transparent),
                    unfocusedContainerColor = colorResource(id = R.color.transparent),
                    disabledLabelColor = colorResource(id = R.color.red),
                    focusedBorderColor = colorResource(id = R.color.black),
                    focusedTextColor = colorResource(id = R.color.black),
                    unfocusedTextColor = colorResource(id = R.color.black),
                )
            )

            Text(
                text = "Confirm Password",
                color = colorResource(id = R.color.black),
                fontSize = 16.sp,
                fontFamily = FontFamily.SansSerif,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp, bottom = 5.dp)
            )

            OutlinedTextField(
                value = rePasswordValue.value,
                onValueChange = { rePasswordValue.value = it },
                placeholder = {
                    Text(
                        text = "Re-Enter your Password",
                        color = colorResource(id = R.color.black),
                        fontSize = 16.sp,
                        fontFamily = FontFamily.SansSerif,
                    )
                },
                trailingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_lock),
                        contentDescription = null,
                        tint = colorResource(id = R.color.black)
                    )
                },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = colorResource(id = R.color.transparent),
                    unfocusedContainerColor = colorResource(id = R.color.transparent),
                    disabledLabelColor = colorResource(id = R.color.red),
                    focusedBorderColor = colorResource(id = R.color.black),
                    focusedTextColor = colorResource(id = R.color.black),
                    unfocusedTextColor = colorResource(id = R.color.black),
                )
            )
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
                if (emailInputValue.value.isNotEmpty() && passwordNumberInputValue.value.isNotEmpty() && rePasswordValue.value.isNotEmpty()) {
                    if (!android.util.Patterns.EMAIL_ADDRESS.matcher(emailInputValue.value)
                            .matches()
                    ) {
                        Toast.makeText(context, "Please enter a valid email", Toast.LENGTH_LONG)
                            .show()
                    } else
                        if (passwordNumberInputValue.value.length < 8) {
                            Toast.makeText(
                                context,
                                "Password must be at least 8 characters",
                                Toast.LENGTH_LONG
                            )
                                .show()
                        } else
                            if (passwordNumberInputValue.value == rePasswordValue.value) {
                                authViewModel.signUp(
                                    emailInputValue.value, passwordNumberInputValue.value
                                )
                            } else {

                                Toast.makeText(
                                    context,
                                    "Password does not match",
                                    Toast.LENGTH_LONG
                                )
                                    .show()
                            }
                } else {
                    Toast.makeText(context, "Please fill all the fields", Toast.LENGTH_LONG)
                        .show()
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.btn_primary), contentColor = Color.White
            ),
            shape = RoundedCornerShape(12.dp),

            ) {
            Text(
                text = "Sign Up", color = colorResource(id = R.color.white), fontSize = 16.sp
            )

            when (val signUpResponse = authViewModel.signUpState.value) {
                is Loading -> {
                    isLoading = true
                }

                is Success -> {
                    val isUserSignedUp = signUpResponse.data
                    LaunchedEffect(isUserSignedUp) {
                        isLoading = false
                        if (isUserSignedUp) {
                            navigator.navigate(HomeScreenDestination)
                        }
                    }
                    isLoading = false
                }

                is Failure -> signUpResponse.apply {
                    isLoading = false
                    LaunchedEffect(e) {
                        Utils.print(e)
                    }
                }
            }
        }
    }

    if (isLoading) {
        Dialog(onDismissRequest = { }) {
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
                            text = "Please Wait....",
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
                        CircularProgressIndicator(
                            modifier = Modifier.width(64.dp),
                            color = colorResource(id = R.color.btn_primary),
                            trackColor = MaterialTheme.colorScheme.surfaceVariant,
                        )
                    }
                }
            }
        }
    }
}

