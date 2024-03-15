package com.thezayin.kainaclean.qoute_history.data.di

import com.google.firebase.firestore.FirebaseFirestore
import com.thezayin.kainaclean.qoute_history.data.repository.QuoteHistoryRepositoryImpl
import com.thezayin.kainaclean.qoute_history.domain.repository.QuoteHistoryRepository
import com.thezayin.kainaclean.qoute_history.domain.usecases.GetAllQuotes
import com.thezayin.kainaclean.qoute_history.domain.usecases.GetCurrentQuoteHistory
import com.thezayin.kainaclean.qoute_history.domain.usecases.QuotesUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object QuoteHistoryModule {

    @Singleton
    @Provides
    fun provideQuoteHistoryRepository(fireStore: FirebaseFirestore): QuoteHistoryRepository {
        return QuoteHistoryRepositoryImpl(fireStore)
    }

    @Singleton
    @Provides
    fun provideGetQuoteUseCases(repository: QuoteHistoryRepository) = QuotesUseCases(
        getAllQuote = GetAllQuotes(repository),
        getCurrentQuoteHistory = GetCurrentQuoteHistory(repository)
    )

}