package com.thezayin.kainaclean.chatbot.data.api

import com.thezayin.kainaclean.chatbot.domain.model.Message
import retrofit2.http.GET
import retrofit2.http.Query

interface BotApi {
    @GET("/get?bid=180701&key=HNALinzc2atw9sWA&uid=[uid]")
    suspend fun sendMessage(@Query("msg") msg: String): Message
}