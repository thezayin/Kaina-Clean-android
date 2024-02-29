package com.thezayin.kainaclean.presentation.onboarding.event

sealed class OnBoardingEvent {
    data object SaveAppEntry : OnBoardingEvent()
}