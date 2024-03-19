package com.thezayin.kainaclean.booking.presentation.screens

import android.os.Build
import android.util.Patterns
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.thezayin.kainaclean.R
import com.thezayin.kainaclean.destinations.BookingScreenSecondDestination
import com.thezayin.kainaclean.main.component.TopBar
import com.thezayin.kainaclean.main.component.dialogs.CustomDialog
import com.thezayin.kainaclean.util.Constants.BOOKING_TEXT_TOP_PADDING
import com.thezayin.kainaclean.util.Constants.BUTTON_BOTTOM_PADDING
import com.thezayin.kainaclean.util.Constants.BUTTON_CORNERS_RADIUS
import com.thezayin.kainaclean.util.Constants.BUTTON_SIZE
import com.thezayin.kainaclean.util.Constants.HORIZONTAL_PADDING
import com.thezayin.kainaclean.util.Constants.TEXT_FIELD_CORNER_RADIUS
import com.thezayin.kainaclean.util.Constants.TEXT_FIELD_TOP_PADDING
import com.thezayin.kainaclean.util.Constants.TEXT_SIZE_NORMAL
import com.thezayin.kainaclean.util.Constants.TOP_BAR_BOTTOM_PADDING
import com.thezayin.kainaclean.util.checkForInternet

@RequiresApi(Build.VERSION_CODES.Q)
@Destination
@Composable
fun BookingScreenFirst(
    navigator: DestinationsNavigator
) {
    val name = remember { mutableStateOf(TextFieldValue()) }
    val phone = remember { mutableStateOf(TextFieldValue()) }
    val email = remember { mutableStateOf(TextFieldValue()) }

    val context = LocalContext.current
    val openDialog = remember { mutableStateOf(false) }
    var checkNetwork by remember { mutableStateOf(false) }

    if (!checkForInternet(context)) {
        checkNetwork = true
    }

    if (openDialog.value) {
        CustomDialog {
            openDialog.value = it
        }
    }
    Box(modifier = Modifier.background(color = colorResource(id = R.color.background))) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(HORIZONTAL_PADDING)
                .statusBarsPadding()
        ) {

            TopBar(
                modifier = Modifier,
                title = "My Bookings",
                callBack = { navigator.navigateUp() }
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = TOP_BAR_BOTTOM_PADDING)
            ) {
                Text(
                    text = "Name",
                    textAlign = TextAlign.Center,
                    color = colorResource(id = R.color.text_color),
                    fontSize = TEXT_SIZE_NORMAL,
                    fontFamily = FontFamily(Font(R.font.noto_sans_bold)),
                    fontWeight = FontWeight.Medium,
                )
                Text(
                    text = "*",
                    textAlign = TextAlign.Center,
                    color = colorResource(id = R.color.red),
                    fontSize = TEXT_SIZE_NORMAL,
                    fontFamily = FontFamily(Font(R.font.noto_sans_bold)),
                    fontWeight = FontWeight.Medium,
                )
            }

            TextField(
                value = name.value,
                onValueChange = {
                    if (it.text.length <= 18) {
                        name.value = it
                    }
                },
                placeholder = {
                    Text(
                        text = "Enter your full name",
                        color = colorResource(id = R.color.grey),
                        fontSize = TEXT_SIZE_NORMAL,
                        fontFamily = FontFamily(Font(R.font.noto_sans_regular)),
                    )
                },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
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
                ),
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = BOOKING_TEXT_TOP_PADDING)
            ) {
                Text(
                    text = "Email",
                    textAlign = TextAlign.Center,
                    color = colorResource(id = R.color.text_color),
                    fontSize = TEXT_SIZE_NORMAL,
                    fontFamily = FontFamily(Font(R.font.noto_sans_bold)),
                    fontWeight = FontWeight.Medium,
                )
                Text(
                    text = "*",
                    textAlign = TextAlign.Center,
                    color = colorResource(id = R.color.red),
                    fontSize = TEXT_SIZE_NORMAL,
                    fontFamily = FontFamily(Font(R.font.noto_sans_bold)),
                    fontWeight = FontWeight.Medium,
                )
            }

            TextField(
                value = email.value,
                onValueChange = {
                    if (it.text.length <= 124) {
                        email.value = it
                    }
                },
                placeholder = {
                    Text(
                        text = "Enter your email",
                        color = colorResource(id = R.color.grey),
                        fontSize = TEXT_SIZE_NORMAL,
                        fontFamily = FontFamily(Font(R.font.noto_sans_regular)),
                    )
                },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
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

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = BOOKING_TEXT_TOP_PADDING)
            ) {
                Text(
                    text = "Phone Number",
                    textAlign = TextAlign.Center,
                    color = colorResource(id = R.color.text_color),
                    fontSize = TEXT_SIZE_NORMAL,
                    fontFamily = FontFamily(Font(R.font.noto_sans_bold)),
                    fontWeight = FontWeight.Medium,
                )
                Text(
                    text = "*",
                    textAlign = TextAlign.Center,
                    color = colorResource(id = R.color.red),
                    fontSize = TEXT_SIZE_NORMAL,
                    fontFamily = FontFamily(Font(R.font.noto_sans_bold)),
                    fontWeight = FontWeight.Medium,
                )
            }

            TextField(
                value = phone.value,
                onValueChange = {
                    if (it.text.length <= 11) {
                        phone.value = it
                    }
                },
                placeholder = {
                    Text(
                        text = "Enter your phone number",
                        color = colorResource(id = R.color.grey),
                        fontSize = TEXT_SIZE_NORMAL,
                        fontFamily = FontFamily(Font(R.font.noto_sans_regular)),
                    )
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
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

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = BUTTON_BOTTOM_PADDING),
                verticalArrangement = Arrangement.Bottom
            ) {
                Button(
                    onClick = {
                        if (email.value.text.isEmpty() || name.value.text.isEmpty() || phone.value.text.isEmpty()) {
                            openDialog.value = true
                        } else if (!Patterns.EMAIL_ADDRESS.matcher(email.value.text)
                                .matches()
                        ) {
                            Toast.makeText(context, "Enter valid Email", Toast.LENGTH_LONG).show()
                        } else {
                            navigator.navigate(
                                BookingScreenSecondDestination(
                                    name.value.text,
                                    email.value.text,
                                    phone.value.text
                                )
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
                    shape = RoundedCornerShape(BUTTON_CORNERS_RADIUS),

                    ) {
                    Text(
                        text = "Next",
                        color = colorResource(id = R.color.white),
                        fontSize = TEXT_SIZE_NORMAL,
                        fontFamily = FontFamily(Font(R.font.noto_sans_medium)),
                    )
                }
            }
        }
    }
}

