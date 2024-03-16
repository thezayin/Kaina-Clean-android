package com.thezayin.kainaclean.booking.presentation.screens

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
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.thezayin.kainaclean.R
import com.thezayin.kainaclean.booking.presentation.viewmodel.BookingViewModel
import com.thezayin.kainaclean.destinations.HomeScreenDestination
import com.thezayin.kainaclean.main.component.TopBar
import com.thezayin.kainaclean.main.component.dialogs.CustomDialog
import com.thezayin.kainaclean.main.component.dialogs.DateSelectorDialog
import com.thezayin.kainaclean.main.component.dialogs.LoadingDialog
import com.thezayin.kainaclean.main.component.dialogs.SuccessDialog
import com.thezayin.kainaclean.util.Constants.BOOKING_TEXT_TOP_PADDING
import com.thezayin.kainaclean.util.Constants.BUTTON_BOTTOM_PADDING
import com.thezayin.kainaclean.util.Constants.BUTTON_CORNERS_RADIUS
import com.thezayin.kainaclean.util.Constants.BUTTON_SIZE
import com.thezayin.kainaclean.util.Constants.DATE_LENGTH
import com.thezayin.kainaclean.util.Constants.HORIZONTAL_PADDING
import com.thezayin.kainaclean.util.Constants.TEXT_FIELD_CORNER_RADIUS
import com.thezayin.kainaclean.util.Constants.TEXT_FIELD_TOP_PADDING
import com.thezayin.kainaclean.util.Constants.TEXT_SIZE_NORMAL
import com.thezayin.kainaclean.util.Response
import com.thezayin.kainaclean.util.Toast
import com.thezayin.kainaclean.util.Utils
import com.thezayin.kainaclean.util.checkForInternet

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
    val viewModel: BookingViewModel = hiltViewModel()
    var showDateDialog by remember { mutableStateOf(false) }

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
    var date by remember { mutableStateOf("Select") }
    var propertySelectedText by remember { mutableStateOf(propertyTypeList[0]) }
    var serviceSelectedText by remember { mutableStateOf(serviceTypeList[0]) }
    var serviceExpanded by remember { mutableStateOf(false) }
    val showAlertDialog = remember { mutableStateOf(false) }
    var showLoadingDialog by remember { mutableStateOf(false) }
    var showSuccessDialog by remember { mutableStateOf(false) }

    val context = LocalContext.current

    var checkNetwork by remember { mutableStateOf(false) }

    if (!checkForInternet(context)) {
        checkNetwork = true

    }

    if (showAlertDialog.value) {
        CustomDialog {
            showAlertDialog.value = it
        }
    }

    if (showDateDialog) {
        DateSelectorDialog(setShowDialog = {
            showDateDialog = it
        }) {
            date = it
        }
    }

    if (showLoadingDialog) {
        LoadingDialog()
    }

    if (showSuccessDialog) {
        SuccessDialog(callBack = { navigator.navigate(HomeScreenDestination) }) {
            showSuccessDialog = it
        }
    }

    Box(modifier = Modifier.background(color = colorResource(id = R.color.background))) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(HORIZONTAL_PADDING)
                .statusBarsPadding()
        ) {

            TopBar(modifier = Modifier,
                title = "Booking a Service",
                callBack = { navigator.navigateUp() })

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = BOOKING_TEXT_TOP_PADDING)
            ) {
                Text(
                    text = "Property Type",
                    textAlign = TextAlign.Center,
                    color = colorResource(id = R.color.text_color),
                    fontSize = TEXT_SIZE_NORMAL,
                    fontFamily = FontFamily(Font(R.font.noto_sans_bold)),
                    fontWeight = FontWeight.Medium,
                )
                Text(
                    text = "*",
                    textAlign = TextAlign.Center,
                    color = colorResource(id = R.color.text_color),
                    fontSize = TEXT_SIZE_NORMAL,
                    fontFamily = FontFamily(Font(R.font.noto_sans_bold)),
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
                        .padding(top = TEXT_FIELD_TOP_PADDING),
                    shape = RoundedCornerShape(TEXT_FIELD_CORNER_RADIUS),
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
                        DropdownMenuItem(text = {
                            Text(
                                text = item,
                                fontSize = TEXT_SIZE_NORMAL,
                                fontFamily = FontFamily(Font(R.font.noto_sans_regular)),
                            )
                        }, onClick = {
                            propertySelectedText = item
                            propertyExpanded = false
                        })
                    }
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = BOOKING_TEXT_TOP_PADDING)
            ) {
                Text(
                    text = "Service Required",
                    textAlign = TextAlign.Center,
                    color = colorResource(id = R.color.text_color),
                    fontSize = TEXT_SIZE_NORMAL,
                    fontFamily = FontFamily(Font(R.font.noto_sans_bold)),
                    fontWeight = FontWeight.Medium,
                )
                Text(
                    text = "*",
                    textAlign = TextAlign.Center,
                    color = colorResource(id = R.color.text_color),
                    fontSize = TEXT_SIZE_NORMAL,
                    fontFamily = FontFamily(Font(R.font.noto_sans_bold)),
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
                        .padding(top = TEXT_FIELD_TOP_PADDING),
                    shape = RoundedCornerShape(TEXT_FIELD_CORNER_RADIUS),
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
                            Text(
                                text = item,
                                fontSize = TEXT_SIZE_NORMAL,
                                fontFamily = FontFamily(Font(R.font.noto_sans_regular)),
                            )
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
                    .padding(top = BOOKING_TEXT_TOP_PADDING)
            ) {
                Text(
                    text = "Date Event",
                    textAlign = TextAlign.Center,
                    color = colorResource(id = R.color.text_color),
                    fontSize = TEXT_SIZE_NORMAL,
                    fontFamily = FontFamily(Font(R.font.noto_sans_bold)),
                    fontWeight = FontWeight.Medium,
                )
                Text(
                    text = "*",
                    textAlign = TextAlign.Center,
                    color = colorResource(id = R.color.text_color),
                    fontSize = TEXT_SIZE_NORMAL,
                    fontFamily = FontFamily(Font(R.font.noto_sans_bold)),
                    fontWeight = FontWeight.Medium,
                )
            }

            TextField(
                value = date,
                onValueChange = {
                },
                placeholder = {
                    Text(
                        fontSize = TEXT_SIZE_NORMAL,
                        text = "Select",
                        color = colorResource(id = R.color.black),
                        fontFamily = FontFamily(Font(R.font.noto_sans_regular)),
                    )
                },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = TEXT_FIELD_TOP_PADDING)
                    .clickable {
                        showDateDialog = true
                    },
                enabled = false,
                shape = RoundedCornerShape(TEXT_FIELD_CORNER_RADIUS),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = colorResource(id = R.color.ed_background),
                    unfocusedContainerColor = colorResource(id = R.color.ed_background),
                    disabledLabelColor = colorResource(id = R.color.red),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledTextColor = colorResource(id = R.color.black),
                    focusedTextColor = colorResource(id = R.color.black),
                    unfocusedTextColor = colorResource(id = R.color.black),
                    disabledSupportingTextColor = colorResource(id = R.color.black),
                    focusedSupportingTextColor = colorResource(id = R.color.black),
                    disabledContainerColor = colorResource(id = R.color.ed_background)
                )
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = BUTTON_BOTTOM_PADDING),
                verticalArrangement = Arrangement.Bottom
            ) {
                Button(
                    onClick = {
                        if (propertySelectedText.isEmpty() || serviceSelectedText.isEmpty() || date.length < DATE_LENGTH) {
                            showAlertDialog.value = true
                        } else {
                            showLoadingDialog = true
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
                        .height(BUTTON_SIZE),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.btn_primary),
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(BUTTON_CORNERS_RADIUS)
                ) {
                    Text(
                        text = "Next",
                        color = colorResource(id = R.color.white),
                        fontSize = TEXT_SIZE_NORMAL,
                        fontFamily = FontFamily(Font(R.font.noto_sans_medium)),
                    )

                    when (val response = viewModel.sendBooking.value) {
                        is Response.Loading -> {
                            showLoadingDialog = true
                        }

                        is Response.Success -> {
                            if (response.data) {
                                showLoadingDialog = false
                                showSuccessDialog = true
                            }
                        }

                        is Response.Failure -> response.apply {
                            showLoadingDialog = false
                            Utils.print(e)
                            Toast(message = e)
                        }
                    }
                }
            }
        }
    }
}
