package com.thezayin.analytics.events

import android.os.Bundle
import com.thezayin.analytics.utils.AnalyticsConstant.BOOKING_HISTORY_SELECTED
import com.thezayin.analytics.utils.AnalyticsConstant.CALL_SELECTED
import com.thezayin.analytics.utils.AnalyticsConstant.CHAT_SELECTED
import com.thezayin.analytics.utils.AnalyticsConstant.CONTACT_US_SELECTED
import com.thezayin.analytics.utils.AnalyticsConstant.ESTIMATE_HISTORY_SELECTED
import com.thezayin.analytics.utils.AnalyticsConstant.LOGOUT_SELECTED
import com.thezayin.analytics.utils.AnalyticsConstant.PRICING_SELECTED
import com.thezayin.analytics.utils.AnalyticsConstant.PRIVACY_POLICY_SELECTED
import com.thezayin.analytics.utils.AnalyticsConstant.PROPERTY_ESTIMATE_SELECTED
import com.thezayin.analytics.utils.AnalyticsConstant.PROPERTY_PRICE_SELECTED
import com.thezayin.analytics.utils.AnalyticsConstant.PROPERTY_SELECTED
import com.thezayin.analytics.utils.AnalyticsConstant.QUOTE_HISTORY_SELECTED
import com.thezayin.analytics.utils.AnalyticsConstant.RATE_US_SELECTED
import com.thezayin.analytics.utils.AnalyticsConstant.REQUEST_BOOKING_SELECTED
import com.thezayin.analytics.utils.AnalyticsConstant.REQUEST_ESTIMATE_SELECTED
import com.thezayin.analytics.utils.AnalyticsConstant.REQUEST_QUOTE_SELECTED
import com.thezayin.analytics.utils.AnalyticsConstant.SERVICE_DETAILS_SELECTED
import com.thezayin.analytics.utils.AnalyticsConstant.SERVICE_ESTIMATE_SELECTED
import com.thezayin.analytics.utils.AnalyticsConstant.SERVICE_PRICE_SELECTED
import com.thezayin.analytics.utils.AnalyticsConstant.SERVICE_QUOTE_SELECTED
import com.thezayin.analytics.utils.AnalyticsConstant.SERVICE_SELECTED
import com.thezayin.analytics.utils.AnalyticsConstant.SETTING_SELECTED

sealed class
AnalyticsEvent(
    val event: String? = null,
    val args: Bundle?
) {

    class PriceSelected(
        status: String
    ) : AnalyticsEvent(
        PRICING_SELECTED,
        Bundle().apply {
            putString("Pricing", status)
        }
    )

    class ServiceSelected(
        status: String
    ) : AnalyticsEvent(
        SERVICE_SELECTED,
        Bundle().apply {
            putString("ServiceSelected", status)
        }
    )

    class QuoteSelected(
        status: String
    ) : AnalyticsEvent(
        REQUEST_QUOTE_SELECTED,
        Bundle().apply {
            putString("QuoteSelected", status)
        }
    )

    class EstimateSelected(
        status: String
    ) : AnalyticsEvent(
        REQUEST_ESTIMATE_SELECTED,
        Bundle().apply {
            putString("EstimateSelected", status)
        }
    )

    class QuoteHistorySelected(
        status: String
    ) : AnalyticsEvent(
        QUOTE_HISTORY_SELECTED,
        Bundle().apply {
            putString("QuoteHistorySelected", status)
        }
    )

    class EstimateHistorySelected(
        status: String
    ) : AnalyticsEvent(
        ESTIMATE_HISTORY_SELECTED,
        Bundle().apply {
            putString("EstimateHistorySelected", status)
        }
    )

    class BookingSelected(
        status: String
    ) : AnalyticsEvent(
        REQUEST_BOOKING_SELECTED,
        Bundle().apply {
            putString("BookingSelected", status)
        }
    )

    class BookingHistorySelected(
        status: String
    ) : AnalyticsEvent(
        BOOKING_HISTORY_SELECTED,
        Bundle().apply {
            putString("BookingHistorySelected", status)
        }
    )

    class ChatSelected(
        status: String
    ) : AnalyticsEvent(
        CHAT_SELECTED,
        Bundle().apply {
            putString("ChatSelected", status)
        }
    )

    class SettingSelected(
        status: String
    ) : AnalyticsEvent(
        SETTING_SELECTED,
        Bundle().apply {
            putString("SettingSelected", status)
        }
    )

    class PrivacySelected(
        status: String
    ) : AnalyticsEvent(
        PRIVACY_POLICY_SELECTED,
        Bundle().apply {
            putString("PrivacySelected", status)
        }
    )

    class ContactSelected(
        status: String
    ) : AnalyticsEvent(
        CONTACT_US_SELECTED,
        Bundle().apply {
            putString("ContactSelected", status)
        }
    )

    class CallSelected(
        status: String
    ) : AnalyticsEvent(
        CALL_SELECTED,
        Bundle().apply {
            putString("CallSelected", status)
        }
    )

    class RateUsSelected(
        status: String
    ) : AnalyticsEvent(
        RATE_US_SELECTED,
        Bundle().apply {
            putString("RateUsSelected", status)
        }
    )

    class LogOutSelected(
        status: String
    ) : AnalyticsEvent(
        LOGOUT_SELECTED,
        Bundle().apply {
            putString("LogOutSelected", status)
        }
    )

    class PropertySelected(
        status: String
    ) : AnalyticsEvent(
        PROPERTY_SELECTED,
        Bundle().apply {
            putString("PropertySelected", status)
        }
    )

    class ServiceDetailsSelected(
        status: String
    ) : AnalyticsEvent(
        SERVICE_DETAILS_SELECTED,
        Bundle().apply {
            putString("ServiceDetailsSelected", status)
        }
    )

    class PropertyPriceSelected(
        status: String
    ) : AnalyticsEvent(
        PROPERTY_PRICE_SELECTED,
        Bundle().apply {
            putString("PropertyPriceSelected", status)
        }
    )

    class ServicePriceSelected(
        status: String
    ) : AnalyticsEvent(
        SERVICE_PRICE_SELECTED,
        Bundle().apply {
            putString("ServicePriceSelected", status)
        }
    )

    class ServiceQuoteSelected(
        status: String
    ) : AnalyticsEvent(
        SERVICE_QUOTE_SELECTED,
        Bundle().apply {
            putString("ServiceQuoteSelected", status)
        }
    )

    class PropertyEstimateSelected(
        status: String
    ) : AnalyticsEvent(
        PROPERTY_ESTIMATE_SELECTED,
        Bundle().apply {
            putString("PropertyEstimateSelected", status)
        }
    )

    class ServiceEstimateSelected(
        status: String
    ) : AnalyticsEvent(
        SERVICE_ESTIMATE_SELECTED,
        Bundle().apply {
            putString("ServiceEstimateSelected", status)
        }
    )
}


