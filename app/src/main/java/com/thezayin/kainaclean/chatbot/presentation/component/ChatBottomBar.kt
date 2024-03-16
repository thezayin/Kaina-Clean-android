package com.thezayin.kainaclean.chatbot.presentation.component

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thezayin.kainaclean.R
import com.thezayin.kainaclean.chatbot.presentation.ChatBotViewModel
import kotlinx.coroutines.launch

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun ChatBottomBar(modifier: Modifier, chatViewModel: ChatBotViewModel, listState: LazyListState) {
    var chatBoxValue by remember { mutableStateOf(TextFieldValue("")) }

    val coroutineScope = rememberCoroutineScope()
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(color = Color.White)
            .padding(horizontal = 10.dp)
            .padding(bottom = 15.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.Bottom
    ) {

        OutlinedTextField(
            value = chatBoxValue,
            onValueChange = { newText ->
                chatBoxValue = newText
            },
            placeholder = {
                Text(
                    text = "Type a message...",
                    color = colorResource(id = R.color.grey),
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.noto_sans_regular)),
                    modifier = Modifier.padding(horizontal = 5.dp)
                )
            },
            modifier = Modifier
                .heightIn(45.dp)
                .fillMaxWidth(0.8f)
                .padding(0.dp, 10.dp, 0.dp, 0.dp),
            shape = RoundedCornerShape(48.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = colorResource(id = R.color.btn_primary),
                focusedTextColor = colorResource(id = R.color.black),
                unfocusedTextColor = colorResource(id = R.color.black),
                unfocusedBorderColor = colorResource(id = R.color.btn_primary),
            ),
        )
        IconButton(
            modifier = Modifier
                .size(55.dp),
            colors = IconButtonDefaults.iconButtonColors(
                containerColor = colorResource(id = R.color.btn_primary),
                contentColor = Color.White
            ),
            onClick = {
                chatViewModel.sendMessage(message = chatBoxValue.text, user = "user")
                chatBoxValue = TextFieldValue("")
                coroutineScope.launch {

                    listState.animateScrollToItem(index = 30)
                }
            }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_send),
                contentDescription = null,
                modifier = Modifier.size(25.dp)
            )
        }
    }
}
