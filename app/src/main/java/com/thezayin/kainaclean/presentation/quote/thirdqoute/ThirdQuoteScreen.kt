package com.thezayin.kainaclean.presentation.quote.thirdqoute

import android.os.Build
import androidx.annotation.RequiresApi
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
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.thezayin.kainaclean.R
import com.thezayin.kainaclean.presentation.destinations.HomeScreenDestination
import com.thezayin.kainaclean.presentation.quote.QuoteViewModel
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
fun ThirdQuoteScreen(
    navigator: DestinationsNavigator,
    name: String,
    email: String,
    phoneNumber: String,
    address: String,
    city: String,
    postCode: String
) {

    val propertyTypeList = arrayOf(
        "Domestic",
        "Commercial"
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

    val context = LocalContext.current
    var propertyExpanded by remember { mutableStateOf(false) }
    var date by remember { mutableStateOf("") }
    var propertySelectedText by remember { mutableStateOf(propertyTypeList[0]) }
    var serviceSelectedText by remember { mutableStateOf(propertyTypeList[0]) }
    var serviceExpanded by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState()
    val viewModel: QuoteViewModel = hiltViewModel()
    val isBottomSheetShow = rememberSaveable {
        mutableStateOf(false)
    }

    val isSuccessBottomSheetShow = rememberSaveable {
        mutableStateOf(false)
    }

    val isBottomLoadingSheetShow = rememberSaveable {
        mutableStateOf(false)
    }

    if (isBottomLoadingSheetShow.value) {
        ModalBottomSheet(
            sheetState = sheetState,
            onDismissRequest = {
                isBottomLoadingSheetShow.value = false
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

    if (isSuccessBottomSheetShow.value) {
        ModalBottomSheet(
            sheetState = sheetState,
            onDismissRequest = {
                isSuccessBottomSheetShow.value = false
                navigator.navigate(HomeScreenDestination)
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
                                isSuccessBottomSheetShow.value = false
                                navigator.navigate(HomeScreenDestination)
                            })
                }

                Row(
                    modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_success),
                        contentDescription = "",
                        modifier = Modifier.size(65.dp)
                    )
                }
                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Send Successfully!",
                        fontSize = 22.sp,
                        color = colorResource(id = R.color.text_color),
                        modifier = Modifier
                            .padding(40.dp, 30.dp, 40.dp, 0.dp)
                            .fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = "Our representer will contact you soon",
                        fontSize = 16.sp,
                        color = colorResource(id = R.color.text_color),
                        modifier = Modifier
                            .padding(40.dp, 0.dp, 40.dp, 50.dp)
                            .fillMaxWidth(),
                        textAlign = TextAlign.Center
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
                modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start
            ) {
                Image(painter = painterResource(id = R.drawable.ic_back),
                    contentDescription = "",
                    modifier = Modifier
                        .size(25.dp)
                        .align(Alignment.CenterVertically)
                        .clickable {
                            navigator.popBackStack()
                        })
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
                    text = "Property Type",
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

            ExposedDropdownMenuBox(
                expanded = propertyExpanded,
                onExpandedChange = {
                    propertyExpanded = !propertyExpanded
                },
                modifier = Modifier.fillMaxWidth()
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
                        unfocusedIndicatorColor = Color.Transparent
                    )
                )

                ExposedDropdownMenu(
                    expanded = propertyExpanded,
                    onDismissRequest = { propertyExpanded = false },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    propertyTypeList.forEach { item ->
                        DropdownMenuItem(
                            text = { Text(text = item) },
                            onClick = {
                                propertySelectedText = item
                                propertyExpanded = false
                            }
                        )
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

            ExposedDropdownMenuBox(
                expanded = serviceExpanded,
                onExpandedChange = {
                    serviceExpanded = !serviceExpanded
                },
                modifier = Modifier.fillMaxWidth()
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
                        unfocusedIndicatorColor = Color.Transparent
                    )
                )
                ExposedDropdownMenu(
                    expanded = serviceExpanded,
                    onDismissRequest = { serviceExpanded = false },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    serviceTypeList.forEach { item ->
                        DropdownMenuItem(
                            text = {
                                Text(text = item)
                            },
                            onClick = {
                                serviceSelectedText = item
                                serviceExpanded = false
                            }
                        )
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
                        isBottomLoadingSheetShow.value = true
                        if (propertySelectedText.isEmpty() || serviceSelectedText.isEmpty() || date.isEmpty()) {
                            isBottomSheetShow.value = true
                        } else {
                            viewModel.sendQuote(
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
                    shape = RoundedCornerShape(12.dp),

                    ) {
                    Text(
                        text = "Next", color = colorResource(id = R.color.white), fontSize = 20.sp
                    )

                    when (val response = viewModel.sendQuote.value) {
                        is Response.Loading -> {
                            isBottomLoadingSheetShow.value = true
                        }

                        is Response.Success -> {
                            if (response.data) {
                                isSuccessBottomSheetShow.value = true
                                isBottomLoadingSheetShow.value = true
                            }
                        }

                        is Response.Failure -> response.apply {
                            isBottomLoadingSheetShow.value = true
                            Utils.print(e)
                            Toast(message = e)
                        }
                    }
                }
            }
        }
    }
}
