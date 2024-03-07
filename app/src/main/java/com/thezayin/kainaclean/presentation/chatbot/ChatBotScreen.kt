package com.thezayin.kainaclean.presentation.chatbot

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.thezayin.kainaclean.presentation.chatbot.component.ReplyComponent

@Preview
@Composable
fun ChatBotScreen() {

    var reply by rememberSaveable {
        mutableStateOf("")
    }

    ReplyComponent(reply = reply, onReplayChange = { reply = it }) {

    }
}