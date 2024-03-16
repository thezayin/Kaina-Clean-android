package com.thezayin.kainaclean.estimate_history.data.di

import com.google.firebase.firestore.FirebaseFirestore
import com.thezayin.kainaclean.estimate_history.data.repository.EstimateHistoryRepositoryImpl
import com.thezayin.kainaclean.estimate_history.domain.repository.EstimateHistoryRepository
import com.thezayin.kainaclean.estimate_history.domain.usecases.EstimateHistoryUseCases
import com.thezayin.kainaclean.estimate_history.domain.usecases.GetAllEstimates
import com.thezayin.kainaclean.estimate_history.domain.usecases.GetCurrentEstimateHistory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object EstimateHistoryModule {

    @Singleton
    @Provides
    fun provideEstimateHistoryRepository(fireStore: FirebaseFirestore): EstimateHistoryRepository {
        return EstimateHistoryRepositoryImpl(fireStore)
    }

    @Singleton
    @Provides
    fun provideEstimateHistoryUseCases(
        repository: EstimateHistoryRepository
    ) = EstimateHistoryUseCases(
        getAllEstimates = GetAllEstimates(repository),
        getCurrentEstimateHistory = GetCurrentEstimateHistory(repository)
    )
}