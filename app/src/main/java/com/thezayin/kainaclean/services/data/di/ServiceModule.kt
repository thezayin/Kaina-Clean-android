package com.thezayin.kainaclean.services.data.di

import com.thezayin.kainaclean.services.data.repository.ServiceOptionsRepositoryImpl
import com.thezayin.kainaclean.services.domain.repository.ServiceOptionsRepository
import com.thezayin.kainaclean.services.domain.usecases.ServiceUseCases
import com.thezayin.kainaclean.services.domain.usecases.ServicesOptionCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object ServiceModule {
    @Singleton
    @Provides
    fun provideServiceOptionsRepository(): ServiceOptionsRepository {
        return ServiceOptionsRepositoryImpl()
    }

    @Singleton
    @Provides
    fun provideServiceUseCases(repository: ServiceOptionsRepository) = ServiceUseCases(
        serviceOptionsCase = ServicesOptionCase(repository),
    )
}