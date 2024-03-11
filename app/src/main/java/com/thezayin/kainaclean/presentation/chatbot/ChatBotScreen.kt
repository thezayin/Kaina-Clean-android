package com.thezayin.kainaclean.presentation.chatbot

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.thezayin.kainaclean.R
import com.thezayin.kainaclean.presentation.chatbot.component.BottomBar
import com.thezayin.kainaclean.presentation.chatbot.component.MessageBody
import com.thezayin.kainaclean.presentation.component.TopBar

@Destination
@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun ChatBotScreen(
    navigator: DestinationsNavigator
) {

    val chatViewModel: ChatBotViewModel = hiltViewModel()
    val listState = rememberLazyListState()

    Scaffold(modifier = Modifier
        .fillMaxSize()
        .navigationBarsPadding()
        .statusBarsPadding(),
        containerColor = colorResource(id = R.color.white),
        topBar = {
            TopBar(modifier = Modifier, title = "Chat Bot") {
                navigator.navigateUp()
            }
        },
        bottomBar = {
            BottomBar(
                modifier = Modifier,
                chatViewModel = chatViewModel,
                listState = listState
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = colorResource(id = R.color.white))
                .padding(padding),
            contentPadding = PaddingValues(),
            state = listState
        ) {
            items(chatViewModel._messageState.size) { message ->
                MessageBody(message = chatViewModel._messageState[message])
            }
        }

    }
}