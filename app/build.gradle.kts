plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    id("kotlin-parcelize")
    id ("com.google.devtools.ksp") version "1.9.22-1.0.17"
    id("com.google.gms.google-services")
    id("com.google.firebase.crashlytics")
    id("com.google.firebase.firebase-perf")
    id("kotlin-kapt")
}

android {
    namespace = "com.thezayin.kainaclean"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.thezayin.kainaclean"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
        signingConfig = signingConfigs.getByName("debug")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("debug")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.8"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(project(":analytics"))
    implementation(project(":core"))

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation(platform("androidx.compose:compose-bom:2024.02.02"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2024.02.02"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    //firebase
    implementation("com.google.firebase:firebase-database:20.3.1")
    implementation("com.google.firebase:firebase-auth-ktx:22.3.1")
    implementation("com.google.firebase:firebase-firestore-ktx:24.10.3")
    implementation("com.google.firebase:firebase-storage-ktx:20.3.0")
    implementation("com.google.firebase:firebase-appcheck-debug:17.1.2")
    implementation(platform("com.google.firebase:firebase-bom:32.7.4"))
    implementation("com.google.firebase:firebase-auth:22.3.1")
    implementation("com.google.firebase:firebase-messaging-ktx:23.4.1")
    implementation("com.google.firebase:firebase-messaging:23.4.1")
    implementation("com.google.firebase:firebase-inappmessaging-display:20.4.0")
    implementation("com.google.firebase:firebase-perf:20.5.2")

    // Add the dependency for the App Check library
    // When using the BoM, you don't specify versions in Firebase library dependencies
    implementation("com.google.firebase:firebase-appcheck")
    implementation ("com.google.firebase:firebase-appcheck-safetynet:16.1.2")

    //Splash Api
    implementation("androidx.core:core-splashscreen:1.0.1")

    //Compose Navigation
    implementation("androidx.navigation:navigation-compose:2.7.7")
    implementation ("androidx.navigation:navigation-compose:2.7.7")

    //Custom Navigation
    implementation("io.github.raamcosta.compose-destinations:core:1.10.2")
    ksp("io.github.raamcosta.compose-destinations:ksp:1.10.2")

    //Dagger Hilt
    implementation("com.google.dagger:hilt-android:2.51")
    kapt("com.google.dagger:hilt-compiler:2.51")
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")

    //Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.10.0")
    implementation("com.squareup.retrofit2:converter-gson:2.10.0")

    //Coil
    implementation("io.coil-kt:coil-compose:2.6.0")

    //Datastore
    implementation("androidx.datastore:datastore-preferences:1.0.0")

    //Compose Foundation
    implementation("androidx.compose.foundation:foundation:1.6.3")

    //Paging 3
    implementation("androidx.paging:paging-runtime-ktx:3.2.1")
    implementation("androidx.paging:paging-compose:3.2.1")

    //slider
    implementation ("com.google.accompanist:accompanist-pager:0.34.0")

    //Room
    implementation("androidx.room:room-runtime:2.6.1")
    ksp("androidx.room:room-compiler:2.6.1")
    implementation("androidx.room:room-ktx:2.6.1")

   //Date Time Picker
    implementation ("io.github.vanpra.compose-material-dialogs:datetime:0.9.0")
    coreLibraryDesugaring ("com.android.tools:desugar_jdk_libs:2.0.4")

    //font
    implementation ("androidx.compose.ui:ui-text-google-fonts:1.6.3")

    //Moshi
    implementation ("com.squareup.moshi:moshi:1.15.1")
    // Retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.10.0")
    // Retrofit with Moshi Converter
    implementation ("com.squareup.moshi:moshi-kotlin:1.15.1")
    implementation ("com.squareup.retrofit2:converter-moshi:2.10.0")

    // Add the dependencies for the Crashlytics and Analytics libraries
    // When using the BoM, you don't specify versions in Firebase library dependencies
    implementation("com.google.firebase:firebase-crashlytics")
    implementation("com.google.firebase:firebase-analytics")
    implementation ("com.google.firebase:firebase-core:21.1.1")

}