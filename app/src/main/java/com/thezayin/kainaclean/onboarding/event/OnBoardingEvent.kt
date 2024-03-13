package com.thezayin.kainaclean.onboarding.event

sealed class OnBoardingEvent {
    data object SaveAppEntry : OnBoardingEvent()
}