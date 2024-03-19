buildscript {
    dependencies {
        classpath("com.google.gms:google-services:4.4.1")
        classpath ("com.google.firebase:firebase-crashlytics-gradle:2.9.9")
        classpath("com.android.tools.build:gradle:8.1.0")
        classpath("com.google.firebase:perf-plugin:1.4.2")

    }
}
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id ("com.android.application") version "8.2.2" apply false
    id ("com.android.library") version "8.0.2" apply false
    id ("org.jetbrains.kotlin.android") version "1.9.22" apply false
    id ("com.google.dagger.hilt.android") version "2.48" apply false
    id("com.google.devtools.ksp") version "1.9.22-1.0.17" apply false
    id ("org.jetbrains.kotlin.plugin.serialization") version "1.8.21"

    // Add the dependency for the Crashlytics Gradle plugin
    id("com.google.firebase.crashlytics") version "2.9.9" apply false
    id("com.google.firebase.firebase-perf") version "1.4.2" apply false
}