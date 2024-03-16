package com.thezayin.kainaclean.util

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

object Constants {

    const val USER_SETTINGS = "user_settings"
    const val APP_ENTRY = "app_entry"
    const val COLLECTION_NAME = "users"

    const val TAG = "AppTag"

    const val DATE_MASK = "##/##/####"
    const val DATE_LENGTH = 8 // Equals to "##/##/####".count { it == '#' }

    //ChatBot Link
    const val CHAT_URL =
        "http://api.brainshop.ai/get?bid=180701&key=HNALinzc2atw9sWA&uid=[uid]&msg="
    const val BASE_URL = "http://api.brainshop.ai/"

    //Buttons
    const val SIGN_IN_BUTTON = "Sign in"
    const val RESET_PASSWORD_BUTTON = "Reset"
    const val SIGN_UP_BUTTON = "Sign up"

    //SIZES
    val BUTTON_SIZE = 50.dp
    val ALERT_CROSS_ICON = 22.dp
    val ALERT_DIALOG_HEIGHT = 200.dp
    val ALERT_DIALOG_HORIZONTAL = 24.dp
    val ALERT_DIALOG_CORNERS = 8.dp

    //Text sizes
    val TEXT_SIZE_NORMAL = 16.sp
    val TEXT_OP_HEADING = 24.sp
    val TEXT_SUBTITLE = 12.sp
    val TEXT_FIELD_TEXT_SIZE = 12.sp
    val ALERT_TITLE = 20.sp

    //Corners
    val TEXT_FIELD_CORNER_RADIUS = 4.dp
    val BUTTON_CORNERS_RADIUS = 12.dp

    //PADDING
    val HORIZONTAL_PADDING = 20.dp
    val BOOKING_TEXT_TOP_PADDING = 15.dp
    val TOP_BAR_BOTTOM_PADDING = 35.dp
    val TEXT_FIELD_TOP_PADDING = 4.dp
    val BUTTON_BOTTOM_PADDING = 35.dp
    val ALERT_DIALOG_BUTTON_PADDING = 35.dp

    //CARD
    val CARDS_CORNERS = 4.dp
    val CARD_STROKE = 1.dp
    val CARD_ROW_PADDING = 16.dp
    val BOUNDARY_CARD_RADIUS = 150.dp
    val BOUNDARY_CARD_SIZE = 48.dp
    val CARD_IMAGE_SIZE = 20.dp
    val CARD_COLUMN_PADDING_START = 12.dp
    val CARD_TEXT_HISTORY_WIDTH = 180.dp
    val CARD_TEXT_ABOVE_PADDING = 4.dp
    val CARD_SUB_TEXT_SIZE = 16.sp
    val TEXT_SUBTITLE_SIZE = 12.sp


    const val RESET_PASSWORD_MESSAGE = "We've sent you an email with a link to reset the password."

}