package com.thezayin.analytics.di

import com.thezayin.analytics.dependencies.Analytics
import com.thezayin.analytics.qualifiers.AnalyticsBroadcast
import com.thezayin.analytics.qualifiers.GoogleAnalytics
import com.thezayin.analytics.repository.AnalyticsEventsBroadcast
import com.thezayin.analytics.repository.FirebaseAnalyticsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
interface AnalyticsFactory {

    @Binds
    @GoogleAnalytics
    fun provideFirebaseAnalytics(firebaseAnalyticsRepository: FirebaseAnalyticsRepository): Analytics

    @Binds
    @AnalyticsBroadcast
    fun providesAnalyticsWrapper(analyticsEventBroadcast: AnalyticsEventsBroadcast): Analytics

}