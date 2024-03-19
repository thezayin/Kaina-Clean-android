package com.thezayin.kainaclean.chatbot.domain.repository

import com.thezayin.kainaclean.chatbot.domain.model.BotMessage

interface BotRepository {
    suspend fun addMessage(string: String): BotMessage
}