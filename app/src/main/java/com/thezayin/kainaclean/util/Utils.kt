package com.thezayin.kainaclean.util

import android.content.Context
import android.util.Log
import android.widget.Toast.LENGTH_LONG
import android.widget.Toast.makeText
import com.thezayin.kainaclean.util.Constants.TAG

class Utils {
    companion object {
        fun print(e: String) = Log.e(TAG, e)

        fun showMessage(
            context: Context,
            message: String?
        ) = makeText(context, message, LENGTH_LONG).show()
    }
}