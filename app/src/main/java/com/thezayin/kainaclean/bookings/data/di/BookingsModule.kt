package com.thezayin.kainaclean.bookings.data.di

import com.google.firebase.firestore.FirebaseFirestore
import com.thezayin.kainaclean.bookings.data.repository.GetBookingsRepositoryImpl
import com.thezayin.kainaclean.bookings.domain.repository.GetBookingsRepository
import com.thezayin.kainaclean.bookings.domain.usecases.GetBookings
import com.thezayin.kainaclean.bookings.domain.usecases.GetBookingsUseCases
import com.thezayin.kainaclean.bookings.domain.usecases.GetCurrentBookings
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object BookingsModule {
    @Provides
    @Singleton
    fun provideGetBookingsRepository(fireStore: FirebaseFirestore): GetBookingsRepository {
        return GetBookingsRepositoryImpl(fireStore)
    }

    @Provides
    @Singleton
    fun provideBookingUseCase(repository: GetBookingsRepository) = GetBookingsUseCases(
        getBookings = GetBookings(repo = repository),
        getCurrentBookings = GetCurrentBookings(repo = repository)
    )

}