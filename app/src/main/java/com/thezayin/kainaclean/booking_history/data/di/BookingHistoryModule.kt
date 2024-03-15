package com.thezayin.kainaclean.booking_history.data.di

import com.google.firebase.firestore.FirebaseFirestore
import com.thezayin.kainaclean.booking_history.data.repository.BookingHistoryRepositoryImpl
import com.thezayin.kainaclean.booking_history.domain.repository.BookingHistoryRepository
import com.thezayin.kainaclean.booking_history.domain.usecases.BookingHistoryUseCases
import com.thezayin.kainaclean.booking_history.domain.usecases.GetAllBookings
import com.thezayin.kainaclean.booking_history.domain.usecases.GetCurrentBookingHistory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object BookingHistoryModule {
    @Provides
    @Singleton
    fun provideGetBookingsRepository(fireStore: FirebaseFirestore): BookingHistoryRepository {
        return BookingHistoryRepositoryImpl(fireStore)
    }

    @Provides
    @Singleton
    fun provideBookingUseCase(repository: BookingHistoryRepository) = BookingHistoryUseCases(
        getAllBookings = GetAllBookings(repo = repository),
        getCurrentBookingHistory = GetCurrentBookingHistory(repo = repository)
    )

}