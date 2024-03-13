package com.thezayin.kainaclean.chatbot.data.repository

import com.thezayin.kainaclean.chatbot.data.api.BotApi
import com.thezayin.kainaclean.chatbot.domain.model.Message
import com.thezayin.kainaclean.chatbot.domain.repository.BotRepository
import javax.inject.Inject

class BotRepositoryImpl @Inject constructor(private val botApi: BotApi) : BotRepository {
    override suspend fun sendMessage(string: String): Message {
        return botApi.sendMessage(string)
    }
}