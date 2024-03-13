package com.thezayin.kainaclean.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.google.firebase.Firebase
import com.google.firebase.appcheck.appCheck
import com.google.firebase.appcheck.safetynet.SafetyNetAppCheckProviderFactory
import com.google.firebase.initialize
import com.ramcosta.composedestinations.DestinationsNavHost
import com.thezayin.kainaclean.NavGraphs
import com.thezayin.kainaclean.ui.theme.KainaCleanTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()

        Firebase.initialize(context = this)
        Firebase.appCheck.installAppCheckProviderFactory(
            SafetyNetAppCheckProviderFactory.getInstance()
        )

        setContent {
            KainaCleanTheme {
                DestinationsNavHost(navGraph = NavGraphs.root)
            }
        }
    }
}
