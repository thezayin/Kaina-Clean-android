package com.thezayin.kainaclean.estimate.presentation.screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.thezayin.kainaclean.R
import com.thezayin.kainaclean.estimate.presentation.viewmodel.AddEstimateViewModel
import com.thezayin.kainaclean.main.component.TopBar
import com.thezayin.kainaclean.main.component.dialogs.DateSelectorDialog
import com.thezayin.kainaclean.services.presentation.screens.components.ServicesComponent
import com.thezayin.kainaclean.services.presentation.viewmodel.ServiceOptionsViewModel
import com.thezayin.kainaclean.util.Constants
import com.thezayin.kainaclean.util.checkForInternet

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Destination
fun AddEstimateScreen(
    navigator: DestinationsNavigator
) {
    val viewModel: AddEstimateViewModel = hiltViewModel()
    val serviceViewModel: ServiceOptionsViewModel = hiltViewModel()
    val addressInputValue = remember { mutableStateOf(TextFieldValue()) }
    var showDateDialog by remember { mutableStateOf(false) }
    var date by remember { mutableStateOf("Select") }

    val propertyTypeList = arrayOf(
        "Domestic", "Commercial"
    )
    val context = LocalContext.current
    var checkNetwork by remember { mutableStateOf(false) }
    if (!checkForInternet(context)) {
        checkNetwork = true

    }
    var propertySelectedText by remember { mutableStateOf(propertyTypeList[0]) }
    var propertyExpanded by remember { mutableStateOf(false) }

    if (showDateDialog) {
        DateSelectorDialog(setShowDialog = {
            showDateDialog = it
        }) {
            date = it
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.background))
            .statusBarsPadding()
            .navigationBarsPadding(),
    ) {
        Column(
            modifier = Modifier
                .background(color = colorResource(id = R.color.background))
                .fillMaxSize()

        ) {
            TopBar(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .padding(top = 20.dp)
                    .weight(0.1f), title = "Request a Quote"
            ) {
                navigator.navigateUp()
            }

            ServicesComponent(serviceViewModel = serviceViewModel, modifier = Modifier.weight(0.2f))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.6f)
                    .padding(horizontal = 20.dp)
                    .padding(top = 10.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = "Address",
                        textAlign = TextAlign.Center,
                        color = colorResource(id = R.color.text_color),
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.noto_sans_bold)),
                        fontWeight = FontWeight.Medium,
                    )
                    Text(
                        text = "*",
                        textAlign = TextAlign.Center,
                        color = colorResource(id = R.color.red),
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.noto_sans_bold)),
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
                            fontSize = 16.sp,
                            fontFamily = FontFamily(Font(R.font.noto_sans_regular)),
                        )
                    },
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp, 5.dp, 0.dp, 0.dp),
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
                        .padding(top = Constants.BOOKING_TEXT_TOP_PADDING)
                ) {
                    Text(
                        text = "Date Event",
                        textAlign = TextAlign.Center,
                        color = colorResource(id = R.color.text_color),
                        fontSize = Constants.TEXT_SIZE_NORMAL,
                        fontFamily = FontFamily(Font(R.font.noto_sans_bold)),
                        fontWeight = FontWeight.Medium,
                    )
                    Text(
                        text = "*",
                        textAlign = TextAlign.Center,
                        color = colorResource(id = R.color.text_color),
                        fontSize = Constants.TEXT_SIZE_NORMAL,
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
                            fontSize = Constants.TEXT_SIZE_NORMAL,
                            text = "Select",
                            color = colorResource(id = R.color.black),
                            fontFamily = FontFamily(Font(R.font.noto_sans_regular)),
                        )
                    },
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = Constants.TEXT_FIELD_TOP_PADDING)
                        .clickable {
                            showDateDialog = true
                        },
                    enabled = false,
                    shape = RoundedCornerShape(Constants.TEXT_FIELD_CORNER_RADIUS),
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

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = Constants.BOOKING_TEXT_TOP_PADDING)
                ) {
                    Text(
                        text = "Property Type",
                        textAlign = TextAlign.Center,
                        color = colorResource(id = R.color.text_color),
                        fontSize = Constants.TEXT_SIZE_NORMAL,
                        fontFamily = FontFamily(Font(R.font.noto_sans_bold)),
                        fontWeight = FontWeight.Medium,
                    )
                    Text(
                        text = "*",
                        textAlign = TextAlign.Center,
                        color = colorResource(id = R.color.text_color),
                        fontSize = Constants.TEXT_SIZE_NORMAL,
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
                            .padding(top = Constants.TEXT_FIELD_TOP_PADDING),
                        shape = RoundedCornerShape(Constants.TEXT_FIELD_CORNER_RADIUS),
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
                                    fontSize = Constants.TEXT_SIZE_NORMAL,
                                    fontFamily = FontFamily(Font(R.font.noto_sans_regular)),
                                )
                            }, onClick = {
                                propertySelectedText = item
                                propertyExpanded = false
                            })
                        }
                    }
                }
            }
            EstimateButton(
                modifier = Modifier.weight(0.1f),
                address = addressInputValue.value.text,
                propertyType = "property",
                date = "date",
                navigator = navigator,
                viewModel = viewModel
            )
        }
    }

}