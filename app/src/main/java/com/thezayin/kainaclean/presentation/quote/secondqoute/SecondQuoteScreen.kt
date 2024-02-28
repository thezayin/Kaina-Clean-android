package com.thezayin.kainaclean.presentation.quote.secondqoute

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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.thezayin.kainaclean.R
import com.thezayin.kainaclean.presentation.destinations.ThirdQuoteScreenDestination

@OptIn(ExperimentalMaterial3Api::class)
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
                        text = "Please Enter all the fields!",
                        fontSize = 22.sp,
                        color = colorResource(id = R.color.text_color),
                        modifier = Modifier.padding(0.dp, 30.dp, 0.dp, 50.dp)
                    )

                }
            }

        }
    }

    Box(modifier = Modifier.background(color = colorResource(id = R.color.background))) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
                .statusBarsPadding()
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_back),
                    contentDescription = "",
                    modifier = Modifier
                        .size(25.dp)
                        .align(Alignment.CenterVertically)
                        .clickable {
                            navigator.navigateUp()
                        }
                )
                Text(
                    text = "Request a Quote",
                    fontSize = 32.sp,
                    color = colorResource(id = R.color.text_color),
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier
                        .padding(horizontal = 50.dp)
                        .align(Alignment.CenterVertically)

                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 50.dp, 0.dp, 0.dp)
            ) {
                Text(
                    text = "Address",
                    textAlign = TextAlign.Center,
                    color = colorResource(id = R.color.text_color),
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Medium,
                )
                Text(
                    text = "*",
                    textAlign = TextAlign.Center,
                    color = colorResource(id = R.color.red),
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Medium,
                )
            }

            TextField(
                value = addressInputValue.value,
                onValueChange = { addressInputValue.value = it },
                placeholder = {
                    Text(text = "Enter your address")
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

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 30.dp, 0.dp, 0.dp)
            ) {
                Text(
                    text = "City",
                    textAlign = TextAlign.Center,
                    color = colorResource(id = R.color.text_color),
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Medium,
                )
                Text(
                    text = "*",
                    textAlign = TextAlign.Center,
                    color = colorResource(id = R.color.red),
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Medium,
                )
            }

            TextField(
                value = cityInputValue.value,
                onValueChange = { cityInputValue.value = it },
                placeholder = {
                    Text(text = "Enter your city")
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

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 30.dp, 0.dp, 0.dp)
            ) {
                Text(
                    text = "Postcode",
                    textAlign = TextAlign.Center,
                    color = colorResource(id = R.color.text_color),
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Medium,
                )
                Text(
                    text = "*",
                    textAlign = TextAlign.Center,
                    color = colorResource(id = R.color.red),
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Medium,
                )
            }

            TextField(
                value = postcodeInputValue.value,
                onValueChange = { postcodeInputValue.value = it },
                placeholder = {
                    Text(text = "Enter your Postcode")
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

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(0.dp, 0.dp, 0.dp, 40.dp),
                verticalArrangement = Arrangement.Bottom
            ) {
                Button(
                    onClick = {
                        if (addressInputValue.value.text.isEmpty() || cityInputValue.value.text.isEmpty() || postcodeInputValue.value.text.isEmpty()) {
                            isBottomSheetShow.value = true
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
                        .height(60.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.btn_primary),
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(12.dp),

                    ) {
                    Text(
                        text = "Next",
                        color = colorResource(id = R.color.white),
                        fontSize = 20.sp
                    )
                }
            }
        }
    }
}