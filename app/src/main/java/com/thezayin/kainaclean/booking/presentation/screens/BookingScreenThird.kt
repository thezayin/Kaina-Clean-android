package com.thezayin.kainaclean.presentation.booking.presentation.screens

import android.os.Build
import androidx.annotation.RequiresApi
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.thezayin.kainaclean.R
import com.thezayin.kainaclean.presentation.booking.presentation.viewmodel.BookingViewModel
import com.thezayin.kainaclean.presentation.component.TopBar
import com.thezayin.kainaclean.presentation.toast.Toast
import com.thezayin.kainaclean.util.Constants.DATE_LENGTH
import com.thezayin.kainaclean.util.Constants.DATE_MASK
import com.thezayin.kainaclean.util.MaskVisualTransformation
import com.thezayin.kainaclean.util.Response
import com.thezayin.kainaclean.util.Utils

@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Destination
@Composable
fun BookingScreenThird(
    navigator: DestinationsNavigator,
    name: String,
    email: String,
    phoneNumber: String,
    address: String,
    city: String,
    postCode: String
) {

    val propertyTypeList = arrayOf(
        "Domestic", "Commercial"
    )

    val serviceTypeList = arrayOf(
        "General Cleaning",
        "Deep Cleaning",
        "After Builders Cleaning",
        "Carpet",
        "Hotel & restaurant",
        "Hostel",
        "Schools & Colleges",
        "Kitchen & Oven Deep",
        "Hand Floor Scrubbing",
        "Sparkle Cleaning",
        "After Builders Cleaning",
        "Gyms & Clubs"
    )

    var propertyExpanded by remember { mutableStateOf(false) }
    var date by remember { mutableStateOf("") }
    var propertySelectedText by remember { mutableStateOf(propertyTypeList[0]) }
    var serviceSelectedText by remember { mutableStateOf(propertyTypeList[0]) }
    var serviceExpanded by remember { mutableStateOf(false) }
    val viewModel: BookingViewModel = hiltViewModel()
    val openDialog = remember { mutableStateOf(false) }
    var isLoading by remember { mutableStateOf(false) }

    Box(modifier = Modifier.background(color = colorResource(id = R.color.background))) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
                .statusBarsPadding()
        ) {

            TopBar(
                modifier = Modifier,
                title = "Booking a Service",
                callBack = { navigator.navigateUp() }
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 50.dp, 0.dp, 0.dp)
            ) {
                Text(
                    text = "Property Type",
                    textAlign = TextAlign.Center,
                    color = colorResource(id = R.color.text_color),
                    fontSize = 18.sp,
                    fontFamily = FontFamily(Font(R.font.nunito_bold)),
                    fontWeight = FontWeight.Medium,
                )
                Text(
                    text = "*",
                    textAlign = TextAlign.Center,
                    color = colorResource(id = R.color.text_color),
                    fontSize = 18.sp,
                    fontFamily = FontFamily(Font(R.font.nunito_bold)),
                    fontWeight = FontWeight.Medium,
                )
            }

            ExposedDropdownMenuBox(
                expanded = propertyExpanded, onExpandedChange = {
                    propertyExpanded = !propertyExpanded
                }, modifier = Modifier.fillMaxWidth()
            ) {
                TextField(
                    value = propertySelectedText,
                    onValueChange = { },
                    readOnly = true,
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = propertyExpanded) },
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .menuAnchor()
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

                ExposedDropdownMenu(
                    expanded = propertyExpanded,
                    onDismissRequest = { propertyExpanded = false },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    propertyTypeList.forEach { item ->
                        DropdownMenuItem(text = { Text(text = item) }, onClick = {
                            propertySelectedText = item
                            propertyExpanded = false
                        })
                    }
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 30.dp, 0.dp, 0.dp)
            ) {
                Text(
                    text = "Service Required",
                    textAlign = TextAlign.Center,
                    color = colorResource(id = R.color.text_color),
                    fontSize = 18.sp,
                    fontFamily = FontFamily(Font(R.font.nunito_bold)),
                    fontWeight = FontWeight.Medium,
                )
                Text(
                    text = "*",
                    textAlign = TextAlign.Center,
                    color = colorResource(id = R.color.text_color),
                    fontSize = 18.sp,
                    fontFamily = FontFamily(Font(R.font.nunito_bold)),
                    fontWeight = FontWeight.Medium,
                )
            }

            ExposedDropdownMenuBox(
                expanded = serviceExpanded, onExpandedChange = {
                    serviceExpanded = !serviceExpanded
                }, modifier = Modifier.fillMaxWidth()
            ) {
                TextField(
                    value = serviceSelectedText,
                    onValueChange = { },
                    readOnly = true,
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = serviceExpanded) },
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .menuAnchor()
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
                ExposedDropdownMenu(
                    expanded = serviceExpanded,
                    onDismissRequest = { serviceExpanded = false },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    serviceTypeList.forEach { item ->
                        DropdownMenuItem(text = {
                            Text(text = item)
                        }, onClick = {
                            serviceSelectedText = item
                            serviceExpanded = false
                        })
                    }
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 30.dp, 0.dp, 0.dp)
            ) {
                Text(
                    text = "Date Event",
                    textAlign = TextAlign.Center,
                    color = colorResource(id = R.color.text_color),
                    fontSize = 18.sp,
                    fontFamily = FontFamily(Font(R.font.nunito_bold)),
                    fontWeight = FontWeight.Medium,
                )
                Text(
                    text = "*",
                    textAlign = TextAlign.Center,
                    color = colorResource(id = R.color.text_color),
                    fontSize = 18.sp,
                    fontFamily = FontFamily(Font(R.font.nunito_bold)),
                    fontWeight = FontWeight.Medium,
                )
            }

            TextField(
                value = date,
                onValueChange = {
                    if (it.length <= DATE_LENGTH) {
                        date = it
                    }
                },
                placeholder = {
                    Text(text = "DD-MM-YYYY")
                },
                visualTransformation = MaskVisualTransformation(DATE_MASK),
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
                    .padding(0.dp, 0.dp, 0.dp, 40.dp),
                verticalArrangement = Arrangement.Bottom
            ) {
                Button(
                    onClick = {
                        if (propertySelectedText.isEmpty() || serviceSelectedText.isEmpty() || date.isEmpty()) {
                            openDialog.value = true
                        } else {
                            isLoading = true
                            viewModel.sendBooking(
                                name,
                                email,
                                phoneNumber,
                                address,
                                city,
                                postCode,
                                propertySelectedText,
                                serviceSelectedText,
                                date
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
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text(
                        text = "Next", color = colorResource(id = R.color.white), fontSize = 20.sp
                    )

                    when (val response = viewModel.sendBooking.value) {
                        is Response.Loading -> {
                            isLoading = true
                        }

                        is Response.Success -> {
                            if (response.data) {
                                navigator.popBackStack()
                                isLoading = false
                            }
                        }

                        is Response.Failure -> response.apply {
                            isLoading = false
                            Utils.print(e)
                            Toast(message = e)
                        }
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
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Please Wait....",
                            fontSize = 20.sp,
                            color = colorResource(id = R.color.text_color)
                        )
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(bottom = 20.dp),
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
                            .padding(top = 10.dp), horizontalArrangement = Arrangement.End
                    ) {
                        Icon(painter = painterResource(id = R.drawable.ic_close_circle),
                            contentDescription = null,
                            modifier = Modifier
                                .size(20.dp)
                                .clickable {
                                    openDialog.value = false
                                })
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
