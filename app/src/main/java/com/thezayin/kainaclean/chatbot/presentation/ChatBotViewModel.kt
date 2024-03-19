package com.thezayin.kainaclean.chatbot.presentation

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresExtension
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thezayin.kainaclean.chatbot.domain.model.BotMessage
import com.thezayin.kainaclean.chatbot.domain.usecases.bot_usecases.MessageUseCases
import com.thezayin.kainaclean.util.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChatBotViewModel @Inject constructor(
    private val useCase: MessageUseCases
) : ViewModel() {
    var _Bot_messageState = mutableStateListOf<BotMessage>()
        private set

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    fun sendMessage(message: String, user: String) {
        _Bot_messageState.add(BotMessage(sender = user, cnt = message))
        viewModelScope.launch {
            useCase.botUseCase(message).collect { response ->
                when (response) {
                    is Response.Success -> {
                        _Bot_messageState.add(
                            response.data.copy(
                                sender = "bot",
                                cnt = response.data.cnt
                            )
                        )
                        Log.d("ChatViewModel", "sendMessage: ${_Bot_messageState}")
                    }

                    is Response.Failure -> {
                        Log.d("ChatViewModel", "sendMessage: ${response.e}")
                    }

                    is Response.Loading -> {
                        Log.d("ChatViewModel", "sendMessage: ${response}")
                    }
                }
            }
        }
    }
}