package com.thezayin.kainaclean.domain.repository

import com.thezayin.kainaclean.domain.model.Message

interface BotRepository {
    suspend fun sendMessage(string: String): Message
}