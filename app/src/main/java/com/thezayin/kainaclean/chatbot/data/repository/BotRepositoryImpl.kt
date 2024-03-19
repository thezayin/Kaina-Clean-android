package com.thezayin.kainaclean.chatbot.data.repository

import com.thezayin.kainaclean.chatbot.data.api.BotApi
import com.thezayin.kainaclean.chatbot.domain.model.BotMessage
import com.thezayin.kainaclean.chatbot.domain.repository.BotRepository
import javax.inject.Inject

class BotRepositoryImpl @Inject constructor(private val botApi: BotApi) : BotRepository {
    override suspend fun addMessage(string: String): BotMessage {
        return botApi.addMessage(string)
    }
}