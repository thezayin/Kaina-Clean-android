package com.thezayin.kainaclean.chatbot.domain.repository

import com.thezayin.kainaclean.chatbot.domain.model.Message

interface BotRepository {
    suspend fun sendMessage(string: String): Message
}