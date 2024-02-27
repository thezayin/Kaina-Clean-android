package com.thezayin.kainaclean.util

import java.util.regex.Matcher
import java.util.regex.Pattern


fun isValidText(text: String): Boolean {
    // Add your custom validation rules here
    return text.matches(Regex("[a-zA-Z]+"))
}

fun isEmailValid(email: String): Boolean {
    val expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$"
    val pattern: Pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
    val matcher: Matcher = pattern.matcher(email)
    return matcher.matches()
}