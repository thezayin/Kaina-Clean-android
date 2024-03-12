package com.thezayin.kainaclean.presentation.booking.data.di

import com.google.firebase.firestore.FirebaseFirestore
import com.thezayin.kainaclean.presentation.booking.data.repository.BookingRepositoryImpl
import com.thezayin.kainaclean.presentation.booking.domain.repository.BookingRepository
import com.thezayin.kainaclean.presentation.booking.domain.usecases.AddBookingUseCase
import com.thezayin.kainaclean.presentation.booking.domain.usecases.BookingUseCases
import com.thezayin.kainaclean.presentation.booking.domain.usecases.GetBookingUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object BookingModule {
    @Provides
    @Singleton
    fun provideBookingRepository(fireStore: FirebaseFirestore): BookingRepository {
        return BookingRepositoryImpl(fireStore)
    }

    @Provides
    @Singleton
    fun provideBookingUseCase(repository: BookingRepository) = BookingUseCases(
        getBookingUseCase = GetBookingUseCase(repo = repository),
        addBookingUseCase = AddBookingUseCase(repo = repository)
    )

}