package com.thezayin.kainaclean.toast

import android.widget.Toast.makeText
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
fun Toast(message: String) {
    makeText(LocalContext.current, message, android.widget.Toast.LENGTH_LONG).show()
}