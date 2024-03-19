package com.thezayin.core.config

import android.util.Log
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.ktx.get
import com.google.firebase.remoteconfig.remoteConfigSettings
import javax.inject.Inject
import javax.inject.Singleton

private const val STOP = "stop"

@Singleton
class RemoteConfig @Inject constructor() {

    private val defaults: Map<String, Any> = mapOf(
        STOP to false,
    )

    private val config = FirebaseRemoteConfig.getInstance().apply {
        setConfigSettingsAsync(remoteConfigSettings {
            minimumFetchIntervalInSeconds = 0
        })
        setDefaultsAsync(defaults)
        fetchAndActivate().let {
            it.addOnCompleteListener {
                Log.d(
                    "RemoteConfig",
                    "fetchAndActivate: ${all.mapValues { (k, v) -> v.asString() }}"
                )
            }
        }
    }
    val stop: Boolean
        get() = config[STOP].asBoolean()
}