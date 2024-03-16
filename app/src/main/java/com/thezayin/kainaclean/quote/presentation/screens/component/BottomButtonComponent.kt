package com.thezayin.kainaclean.quote.presentation.screens.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.thezayin.kainaclean.R
import com.thezayin.kainaclean.destinations.HomeScreenDestination
import com.thezayin.kainaclean.main.component.dialogs.CustomDialog
import com.thezayin.kainaclean.main.component.dialogs.LoadingDialog
import com.thezayin.kainaclean.main.component.dialogs.SuccessDialog
import com.thezayin.kainaclean.quote.presentation.viewmodel.QuoteViewModel
import com.thezayin.kainaclean.util.Response
import com.thezayin.kainaclean.util.Toast
import com.thezayin.kainaclean.util.Utils

@Composable
fun BottomButtonComponent(
    modifier: Modifier,
    address: String,
    quote: String,
    viewModel: QuoteViewModel,
    navigator: DestinationsNavigator
) {
    val showAlertDialog = remember { mutableStateOf(false) }
    var showLoadingDialog by remember { mutableStateOf(false) }
    var showSuccessDialog by remember { mutableStateOf(false) }

    if (showAlertDialog.value) {
        CustomDialog {
            showAlertDialog.value = it
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
                    showAlertDialog.value = true
                } else {
                    showLoadingDialog = true
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
                text = "Submit",
                color = colorResource(id = R.color.white),
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.noto_sans_bold)),
            )

            when (val response = viewModel.sendQuote.value) {
                is Response.Failure -> response.apply {
                    showLoadingDialog = false
                    Utils.print(e)
                    Toast(message = e)
                }

                is Response.Loading -> {
                    showLoadingDialog = true
                }

                is Response.Success -> {
                    if (response.data) {
                        showLoadingDialog = false
                        showSuccessDialog = true
                    }
                }
            }
        }
    }
}