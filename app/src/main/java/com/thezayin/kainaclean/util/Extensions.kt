package com.thezayin.kainaclean.util

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


fun Context.getActivity(): AppCompatActivity? = when (this) {
    is AppCompatActivity -> this
    is ContextWrapper -> baseContext.getActivity()
    else -> null
}

fun Activity.sendMail(context: Activity) {
    val i = Intent(Intent.ACTION_SEND)
    i.setType("message/rfc822")
    i.putExtra(Intent.EXTRA_EMAIL, arrayOf("recipient@example.com"))
    i.putExtra(Intent.EXTRA_SUBJECT, "subject of email")
    i.putExtra(Intent.EXTRA_TEXT, "body of email")
    try {
        startActivity(Intent.createChooser(i, "Send mail..."))
    } catch (ex: ActivityNotFoundException) {
        Toast.makeText(context, "There are no email clients installed.", Toast.LENGTH_SHORT)
            .show()
    }
}

fun Context.dial(phone: String) {
    try {
        val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null))
        startActivity(intent)
    } catch (t: Throwable) {
        Response.Failure(t.localizedMessage ?: "Error")
    }
}