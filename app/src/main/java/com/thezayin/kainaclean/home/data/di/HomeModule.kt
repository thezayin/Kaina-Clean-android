package com.thezayin.kainaclean.home.data.di

import com.thezayin.kainaclean.home.data.repository.HomeRepositoryImpl
import com.thezayin.kainaclean.home.domain.repository.HomeRepository
import com.thezayin.kainaclean.home.domain.usecases.HomeItem
import com.thezayin.kainaclean.home.domain.usecases.HomeUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object HomeModule {
    @Provides
    @Singleton
    fun provideHomeRepository(): HomeRepository {
        return HomeRepositoryImpl()
    }

    @Provides
    @Singleton
    fun provideHomeUseCase(repository: HomeRepository) = HomeUseCase(
        homeItem = HomeItem(repo = repository)
    )
}