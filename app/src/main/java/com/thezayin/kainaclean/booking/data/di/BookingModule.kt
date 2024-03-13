package com.thezayin.kainaclean.booking.data.di

import com.google.firebase.firestore.FirebaseFirestore
import com.thezayin.kainaclean.booking.data.repository.BookingRepositoryImpl
import com.thezayin.kainaclean.booking.domain.repository.BookingRepository
import com.thezayin.kainaclean.booking.domain.usecases.AddBookingUseCase
import com.thezayin.kainaclean.booking.domain.usecases.BookingUseCases
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
        addBookingUseCase = AddBookingUseCase(repo = repository)
    )

}