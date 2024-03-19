package com.thezayin.kainaclean.chatbot.domain.usecases.bot_usecases

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import com.thezayin.kainaclean.chatbot.domain.model.BotMessage
import com.thezayin.kainaclean.chatbot.domain.repository.BotRepository
import com.thezayin.kainaclean.util.Response
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class BotUseCase @Inject constructor(
    private val botRepository: BotRepository
) {
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    operator fun invoke(message: String): Flow<Response<BotMessage>> = flow {
        try {
            emit(Response.Loading)
            val response = botRepository.addMessage(message)
            emit(Response.Success(response))
        } catch (e: HttpException) {
            emit(Response.Failure(e.localizedMessage ?: "Unexpected Error"))
        } catch (e: IOException) {
            emit(Response.Failure(e.localizedMessage ?: "Unexpected Error"))
        }
    }
}