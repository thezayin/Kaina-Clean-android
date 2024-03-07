package com.thezayin.kainaclean.presentation.quote.firstqoute

import android.os.Build
import android.util.Patterns
import android.widget.Toast
import androidx.annotation.RequiresApi
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.thezayin.kainaclean.R
import com.thezayin.kainaclean.presentation.destinations.SecondQuoteScreenDestination

@RequiresApi(Build.VERSION_CODES.Q)
@Destination
@Composable
fun FirstQuoteScreen(
    navigator: DestinationsNavigator
) {
    val nameInputValue = remember { mutableStateOf(TextFieldValue()) }
    val phoneNumberInputValue = remember { mutableStateOf(TextFieldValue()) }
    val emailInputValue = remember { mutableStateOf(TextFieldValue()) }
    val context = LocalContext.current
    val openDialog = remember { mutableStateOf(false) }

    Box(modifier = Modifier.background(color = colorResource(id = R.color.background))) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
                .statusBarsPadding()
        ) {

            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(painter = painterResource(id = R.drawable.ic_back),
                    contentDescription = "",
                    modifier = Modifier
                        .size(22.dp)
                        .fillMaxHeight()
                        .align(Alignment.CenterStart)
                        .clickable {
                            navigator.popBackStack()
                        })
                Text(
                    text = "Request a Quote",
                    fontSize = 24.sp,
                    color = colorResource(id = R.color.text_color),
                    fontWeight = FontWeight.Medium,
                    fontFamily = FontFamily(Font(R.font.nunito_extrabold)),
                    modifier = Modifier
                        .align(alignment = Alignment.Center)
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 40.dp, 0.dp, 0.dp)
            ) {
                Text(
                    text = "Name",
                    textAlign = TextAlign.Center,
                    color = colorResource(id = R.color.text_color),
                    fontSize = 18.sp,
                    fontFamily = FontFamily(Font(R.font.nunito_bold)),
                    fontWeight = FontWeight.Medium,
                )
                Text(
                    text = "*",
                    textAlign = TextAlign.Center,
                    color = colorResource(id = R.color.red),
                    fontSize = 18.sp,
                    fontFamily = FontFamily(Font(R.font.nunito_medium)),
                    fontWeight = FontWeight.Medium,
                )
            }

            TextField(
                value = nameInputValue.value,
                onValueChange = {
                    if (it.text.length <= 18) {
                        nameInputValue.value = it
                    }
                },
                placeholder = {
                    Text(
                        text = "Enter your full name",
                        color = colorResource(id = R.color.grey),
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.nunito_medium)),
                    )
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
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedTextColor = colorResource(id = R.color.black),
                    unfocusedTextColor = colorResource(id = R.color.black)
                ),
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 20.dp, 0.dp, 0.dp)
            ) {
                Text(
                    text = "Email",
                    textAlign = TextAlign.Center,
                    color = colorResource(id = R.color.text_color),
                    fontSize = 18.sp,
                    fontFamily = FontFamily(Font(R.font.nunito_bold)),
                    fontWeight = FontWeight.Medium,
                )
                Text(
                    text = "*",
                    textAlign = TextAlign.Center,
                    color = colorResource(id = R.color.red),
                    fontSize = 18.sp,
                    fontFamily = FontFamily(Font(R.font.nunito_bold)),
                    fontWeight = FontWeight.Medium,
                )
            }

            TextField(
                value = emailInputValue.value,
                onValueChange = {
                    if (it.text.length <= 124) {
                        emailInputValue.value = it
                    }
                },
                placeholder = {
                    Text(
                        text = "Enter your email",
                        color = colorResource(id = R.color.grey),
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.nunito_medium)),
                    )
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
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedTextColor = colorResource(id = R.color.black),
                    unfocusedTextColor = colorResource(id = R.color.black)
                )
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 20.dp, 0.dp, 0.dp)
            ) {
                Text(
                    text = "Phone Number",
                    textAlign = TextAlign.Center,
                    color = colorResource(id = R.color.text_color),
                    fontSize = 18.sp,
                    fontFamily = FontFamily(Font(R.font.nunito_bold)),
                    fontWeight = FontWeight.Medium,
                )
                Text(
                    text = "*",
                    textAlign = TextAlign.Center,
                    color = colorResource(id = R.color.red),
                    fontSize = 18.sp,
                    fontFamily = FontFamily(Font(R.font.nunito_bold)),
                    fontWeight = FontWeight.Medium,
                )
            }

            TextField(
                value = phoneNumberInputValue.value,
                onValueChange = {
                    if (it.text.length <= 11) {
                        phoneNumberInputValue.value = it
                    }
                },
                placeholder = {
                    Text(
                        text = "Enter your phone number",
                        color = colorResource(id = R.color.grey),
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.nunito_medium)),
                    )
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
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
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedTextColor = colorResource(id = R.color.black),
                    unfocusedTextColor = colorResource(id = R.color.black)
                )
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(0.dp, 0.dp, 0.dp, 15.dp),
                verticalArrangement = Arrangement.Bottom
            ) {
                Button(
                    onClick = {
                        if (emailInputValue.value.text.isEmpty() || nameInputValue.value.text.isEmpty() || phoneNumberInputValue.value.text.isEmpty()) {
                            openDialog.value = true
                        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInputValue.value.text)
                                .matches()
                        ) {
                            Toast.makeText(context, "Enter valid Email", Toast.LENGTH_LONG).show()
                        } else {
                            navigator.navigate(
                                SecondQuoteScreenDestination(
                                    nameInputValue.value.text,
                                    emailInputValue.value.text,
                                    phoneNumberInputValue.value.text
                                )
                            )
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
                        text = "Next", color = colorResource(id = R.color.white), fontSize = 20.sp
                    )
                }
            }
        }
    }

    if (openDialog.value) {
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
                            .padding(horizontal = 10.dp)
                            .padding(top = 10.dp),
                        horizontalArrangement = Arrangement.End
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_close_circle),
                            contentDescription = null,
                            modifier = Modifier
                                .size(20.dp)
                                .clickable {
                                    openDialog.value = false
                                }
                        )
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(bottom = 20.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Please fill all fields",
                            modifier = Modifier,
                            textAlign = TextAlign.Center,
                            fontSize = 22.sp,
                            fontFamily = FontFamily(Font(R.font.nunito_bold))
                        )
                    }
                }
            }
        }
    }
}

