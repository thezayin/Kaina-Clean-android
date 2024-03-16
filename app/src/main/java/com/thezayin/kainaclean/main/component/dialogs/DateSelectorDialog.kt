package com.thezayin.kainaclean.main.component.dialogs

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api

import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import com.thezayin.kainaclean.R
import com.thezayin.kainaclean.util.DateUtils

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DateSelectorDialog(setShowDialog: (Boolean) -> Unit, setDate: (String) -> Unit) {
    val dateState = rememberDatePickerState()
    val millisToLocalDate = dateState.selectedDateMillis?.let {
        DateUtils().convertMillisToLocalDate(it)
    }
    val dateToString = millisToLocalDate?.let {
        DateUtils().dateToString(millisToLocalDate)
    } ?: "Select"
    DatePickerDialog(
        onDismissRequest = { setShowDialog(false) },
        confirmButton = {
            Button(
                onClick = {
                    setShowDialog(false)
                    setDate(dateToString)
                }
            ) {
                Text(text = "OK", fontFamily = FontFamily(Font(R.font.noto_sans_regular)))
            }
        },
        dismissButton = {
            Button(
                onClick = { setShowDialog(false) }
            ) {
                Text(text = "Cancel", fontFamily = FontFamily(Font(R.font.noto_sans_regular)))
            }
        }
    ) {
        DatePicker(
            state = dateState,
            showModeToggle = true
        )
    }
}
