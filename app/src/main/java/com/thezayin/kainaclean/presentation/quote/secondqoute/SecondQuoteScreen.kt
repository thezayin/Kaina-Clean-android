package com.thezayin.kainaclean.presentation.quote.secondqoute

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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.thezayin.kainaclean.R
import com.thezayin.kainaclean.presentation.destinations.ThirdQuoteScreenDestination

@Destination
@Composable
fun SecondQuoteScreen(
    navigator: DestinationsNavigator,
    name: String,
    email: String,
    phoneNumber: String
) {
    val addressInputValue = remember { mutableStateOf(TextFieldValue()) }
    val cityInputValue = remember { mutableStateOf(TextFieldValue()) }
    val postcodeInputValue = remember { mutableStateOf(TextFieldValue()) }


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
                    text = "Address",
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
                value = addressInputValue.value,
                onValueChange = {
                    if (it.text.length <= 30) {
                        addressInputValue.value = it
                    }
                },
                placeholder = {
                    Text(
                        text = "Enter your address",
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
                    text = "City",
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
                value = cityInputValue.value,
                onValueChange = {
                    if (it.text.length <= 10) {
                        cityInputValue.value = it
                    }
                },
                placeholder = {
                    Text(
                        text = "Enter your city",
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
                    text = "Postcode",
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
                value = postcodeInputValue.value,
                onValueChange = {
                    if (it.text.length <= 7) {
                        postcodeInputValue.value = it
                    }
                },
                placeholder = {
                    Text(
                        text = "Enter your Postcode",
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

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(0.dp, 0.dp, 0.dp, 15.dp),
                verticalArrangement = Arrangement.Bottom
            ) {
                Button(
                    onClick = {
                        if (addressInputValue.value.text.isEmpty() || cityInputValue.value.text.isEmpty() || postcodeInputValue.value.text.isEmpty()) {
                            openDialog.value = true
                        } else {
                            navigator.navigate(
                                ThirdQuoteScreenDestination(
                                    name,
                                    email,
                                    phoneNumber,
                                    addressInputValue.value.text,
                                    cityInputValue.value.text,
                                    postcodeInputValue.value.text
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