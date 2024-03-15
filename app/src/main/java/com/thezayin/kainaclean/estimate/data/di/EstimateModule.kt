package com.thezayin.kainaclean.estimate.data.di

import com.google.firebase.firestore.FirebaseFirestore
import com.thezayin.kainaclean.estimate.data.repository.RequestEstimateRepositoryImpl
import com.thezayin.kainaclean.estimate.domain.repository.RequestEstimateRepository
import com.thezayin.kainaclean.estimate.domain.usecases.AddEstimate
import com.thezayin.kainaclean.estimate.domain.usecases.AddEstimateUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object EstimateModule {
    @Provides
    @Singleton
    fun provideEstimateRepository(fireStore: FirebaseFirestore): RequestEstimateRepository {
        return RequestEstimateRepositoryImpl(fireStore)
    }

    @Provides
    @Singleton
    fun provideEstimateUseCase(requestEstimateRepository: RequestEstimateRepository) =
        AddEstimateUseCases(
            addEstimate = AddEstimate(requestEstimateRepository)
        )
}