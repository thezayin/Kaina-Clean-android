package com.thezayin.kainaclean.quote.data.di

import com.google.firebase.firestore.FirebaseFirestore
import com.thezayin.kainaclean.quote.data.repository.QuoteServiceRepositoryImpl
import com.thezayin.kainaclean.quote.domain.repository.QuoteServiceRepository
import com.thezayin.kainaclean.quote.domain.usecases.QuoteServiceCase
import com.thezayin.kainaclean.quote.domain.usecases.QuoteUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object QuoteModule {

    @Singleton
    @Provides
    fun provideQuoteServiceRepository(firestore: FirebaseFirestore): QuoteServiceRepository {
        return QuoteServiceRepositoryImpl(firestore)
    }

    @Singleton
    @Provides
    fun provideQuoteUseCases(repository: QuoteServiceRepository) = QuoteUseCases(
        quoteServiceUseCase = QuoteServiceCase(repository)
    )

}