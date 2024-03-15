package com.thezayin.kainaclean.quote.presentation.screens.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.thezayin.kainaclean.R
import com.thezayin.kainaclean.destinations.HomeScreenDestination
import com.thezayin.kainaclean.quote.presentation.viewmodel.QuoteViewModel
import com.thezayin.kainaclean.toast.Toast
import com.thezayin.kainaclean.util.Response
import com.thezayin.kainaclean.util.Utils

@Composable
fun BottomButtonComponent(
    modifier: Modifier,
    address: String,
    quote: String,
    viewModel: QuoteViewModel,
    navigator: DestinationsNavigator
) {
    val openDialog = remember { mutableStateOf(false) }
    var isLoading by remember { mutableStateOf(false) }
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)
            .padding(0.dp, 0.dp, 0.dp, 15.dp),
        verticalArrangement = Arrangement.Bottom
    ) {
        Button(
            onClick = {
                if (address.isEmpty() || quote.isEmpty()) {
                    openDialog.value = true
                } else {
                    isLoading = true
                    viewModel.sendQuote(
                        address = address,
                        quote = quote,
                        serviceType = "General Cleaning"
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
                text = "Submit", color = colorResource(id = R.color.white), fontSize = 20.sp
            )

            when (val response = viewModel.sendQuote.value) {
                is Response.Failure -> response.apply {
                    isLoading = false
                    Utils.print(e)
                    Toast(message = e)
                }

                is Response.Loading -> {
                    isLoading = true
                }

                is Response.Success -> {
                    if (response.data) {
                        isLoading = false
                        navigator.navigate(HomeScreenDestination)
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