package com.thezayin.kainaclean.quote.data.di

import com.google.firebase.firestore.FirebaseFirestore
import com.thezayin.kainaclean.quote.data.repository.QuoteServiceRepositoryImpl
import com.thezayin.kainaclean.services.data.repository.ServiceOptionsRepositoryImpl
import com.thezayin.kainaclean.quote.domain.repository.QuoteServiceRepository
import com.thezayin.kainaclean.services.domain.repository.ServiceOptionsRepository
import com.thezayin.kainaclean.services.domain.usecases.QuoteServiceCase
import com.thezayin.kainaclean.quote.domain.usecases.QuoteUseCases
import com.thezayin.kainaclean.quote.domain.usecases.service.ServiceUseCases
import com.thezayin.kainaclean.services.domain.usecases.ServicesOptionCase
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
    fun provideQuoteServiceRepository(fireStore: FirebaseFirestore): QuoteServiceRepository {
        return QuoteServiceRepositoryImpl(fireStore)
    }

    @Singleton
    @Provides
    fun provideQuoteUseCases(repository: QuoteServiceRepository) = QuoteUseCases(
        quoteServiceUseCase = QuoteServiceCase(repository)
    )
}