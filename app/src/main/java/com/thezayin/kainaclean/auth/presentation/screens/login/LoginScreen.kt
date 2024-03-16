package com.thezayin.kainaclean.auth.presentation.screens.login

import android.widget.Toast
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.thezayin.kainaclean.R
import com.thezayin.kainaclean.auth.presentation.viewmodel.AuthViewModel
import com.thezayin.kainaclean.destinations.ForgetPasswordScreenDestination
import com.thezayin.kainaclean.destinations.HomeScreenDestination
import com.thezayin.kainaclean.main.component.dialogs.LoadingDialog
import com.thezayin.kainaclean.main.component.dialogs.NetworkDialog
import com.thezayin.kainaclean.util.Response.Failure
import com.thezayin.kainaclean.util.Response.Loading
import com.thezayin.kainaclean.util.Response.Success
import com.thezayin.kainaclean.util.checkForInternet

@Destination
@Composable
fun LoginScreen(
    navigator: DestinationsNavigator
) {
    val authViewModel: AuthViewModel = hiltViewModel()
    val emailState = remember { mutableStateOf("") }
    val passwordState = remember { mutableStateOf("") }
    val showProgressBar = remember { mutableStateOf(false) }
    var checkNetwork by remember { mutableStateOf(false) }
    val context = LocalContext.current

    if (!checkForInternet(context)) {
        checkNetwork = true
    }

    if (checkNetwork) {
        NetworkDialog(showDialog = { checkNetwork = it })
    }

    if (showProgressBar.value) {
        LoadingDialog()
    }

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
                .padding(horizontal = 20.dp), verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = "Email",
                color = colorResource(id = R.color.black),
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.noto_sans_bold)),
                modifier = Modifier.fillMaxWidth()

            )
            OutlinedTextField(
                value = emailState.value,
                trailingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_mail),
                        contentDescription = null,
                        tint = colorResource(id = R.color.btn_primary)
                    )
                },
                onValueChange = { emailState.value = it },
                placeholder = {
                    Text(
                        text = "Enter your Email",
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.noto_sans_regular)),
                        color = colorResource(id = R.color.black)
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
                    focusedBorderColor = colorResource(id = R.color.black),
                    focusedTextColor = colorResource(id = R.color.black),
                    unfocusedTextColor = colorResource(id = R.color.grey_level_2),
                )
            )
            Text(
                text = "Password",
                color = colorResource(id = R.color.black),
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.noto_sans_bold)),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp)

            )
            OutlinedTextField(
                value = passwordState.value,
                onValueChange = { passwordState.value = it },
                placeholder = {
                    Text(
                        text = "Enter your Password",
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.noto_sans_regular)),
                        color = colorResource(id = R.color.black)
                    )
                },
                trailingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_lock),
                        contentDescription = null,
                        tint = colorResource(id = R.color.btn_primary)
                    )
                },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp),
                shape = RoundedCornerShape(8.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = colorResource(id = R.color.transparent),
                    unfocusedContainerColor = colorResource(id = R.color.transparent),
                    disabledLabelColor = colorResource(id = R.color.red),
                    focusedBorderColor = colorResource(id = R.color.black),
                    focusedTextColor = colorResource(id = R.color.black),
                    unfocusedTextColor = colorResource(id = R.color.grey_level_2),
                ),
                visualTransformation = PasswordVisualTransformation()
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 4.dp)
                    .padding(top = 20.dp),
                horizontalArrangement = Arrangement.End
            ) {
                Text(text = "Forgot Password?",
                    fontSize = 16.sp,
                    color = colorResource(id = R.color.black),
                    fontFamily = FontFamily(Font(R.font.noto_sans_bold)),
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
                    if (emailState.value.isEmpty() || passwordState.value.isEmpty()) {
                        Toast.makeText(context, "Please fill all the fields", Toast.LENGTH_LONG)
                            .show()
                        return@Button
                    } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(emailState.value)
                            .matches()
                    ) {
                        Toast.makeText(context, "Please enter a valid email", Toast.LENGTH_LONG)
                            .show()
                    } else {
                        showProgressBar.value = true
                        authViewModel.signIn(emailState.value, passwordState.value)
                    }
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
                    text = "Sign in",
                    color = colorResource(id = R.color.white),
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.noto_sans_medium)),
                )
                when (val signInResponse = authViewModel.signInState.value) {
                    is Loading -> {
                        showProgressBar.value = true
                    }

                    is Success -> {
                        if (signInResponse.data) {
                            navigator.navigate(HomeScreenDestination)
                        }
                        showProgressBar.value = false
                    }

                    is Failure -> signInResponse.apply {
                        showProgressBar.value = false
                        Toast.makeText(context, e, Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }
}
