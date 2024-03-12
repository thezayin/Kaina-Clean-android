package com.thezayin.kainaclean.data.repository

import com.thezayin.kainaclean.data.api.BotApi
import com.thezayin.kainaclean.domain.model.Message
import com.thezayin.kainaclean.domain.repository.BotRepository
import javax.inject.Inject

class BotRepositoryImpl @Inject constructor(private val botApi: BotApi) : BotRepository {
    override suspend fun sendMessage(string: String): Message {
        return botApi.sendMessage(string)
    }
}