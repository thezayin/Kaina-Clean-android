package com.thezayin.kainaclean.chatbot.data.di

import com.thezayin.kainaclean.chatbot.data.api.BotApi
import com.thezayin.kainaclean.chatbot.data.repository.BotRepositoryImpl
import com.thezayin.kainaclean.chatbot.domain.repository.BotRepository
import com.thezayin.kainaclean.chatbot.domain.usecases.bot_usecases.BotUseCase
import com.thezayin.kainaclean.chatbot.domain.usecases.bot_usecases.MessageUseCases
import com.thezayin.kainaclean.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ChatModule {
    @Singleton
    @Provides
    fun provideBotApi(): BotApi {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(BotApi::class.java)
    }

    @Provides
    @Singleton
    fun provideBotRepository(botApi: BotApi): BotRepository {
        return BotRepositoryImpl(botApi)
    }

    @Provides
    @Singleton
    fun provideUseCase(repository: BotRepository) =
        MessageUseCases(botUseCase = BotUseCase(repository))
}