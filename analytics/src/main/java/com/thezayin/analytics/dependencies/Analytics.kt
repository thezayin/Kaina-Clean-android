package com.thezayin.analytics.dependencies

import com.thezayin.analytics.events.AnalyticsEvent


interface Analytics {
    fun logEvent(event: AnalyticsEvent)
}