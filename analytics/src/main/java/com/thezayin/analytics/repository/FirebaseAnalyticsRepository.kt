package com.thezayin.analytics.repository

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import com.google.firebase.analytics.FirebaseAnalytics
import com.thezayin.analytics.dependencies.Analytics
import com.thezayin.analytics.events.AnalyticsEvent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class FirebaseAnalyticsRepository @Inject constructor(
    @ApplicationContext context: Context
) : Analytics {

    @SuppressLint("MissingPermission")
    private val analytics = FirebaseAnalytics.getInstance(context)

    override fun logEvent(event: AnalyticsEvent) {
        Log.d(
            "AnalyticsTAG",
            "FirebaseAnalyticsRepository eventName....${event.event} arguments... ${event.args} "
        )

        event.event?.let { eventName ->
            analytics.logEvent(eventName, event.args)
        }
    }
}
