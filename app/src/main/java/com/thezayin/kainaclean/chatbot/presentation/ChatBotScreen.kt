package com.thezayin.kainaclean.chatbot.presentation

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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.thezayin.kainaclean.R
import com.thezayin.kainaclean.chatbot.presentation.component.ChatBottomBar
import com.thezayin.kainaclean.chatbot.presentation.component.ChatMessageBody
import com.thezayin.kainaclean.main.component.TopBar
import com.thezayin.kainaclean.util.checkForInternet

@Destination
@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun ChatBotScreen(
    navigator: DestinationsNavigator
) {

    val chatViewModel: ChatBotViewModel = hiltViewModel()
    val listState = rememberLazyListState()

    val context = LocalContext.current
    var checkNetwork by remember { mutableStateOf(false) }
    if (!checkForInternet(context)) {
        checkNetwork = true

    }

    Scaffold(modifier = Modifier
        .fillMaxSize()
        .navigationBarsPadding()
        .statusBarsPadding(),
        containerColor = colorResource(id = R.color.white),
        topBar = {
            TopBar(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .padding(top = 20.dp),
                title = "Chat Bot"
            ) {
                navigator.navigateUp()
            }
        },
        bottomBar = {
            ChatBottomBar(
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
                ChatMessageBody(message = chatViewModel._messageState[message])
            }
        }
    }
}