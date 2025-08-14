plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin")
    id("com.google.dagger.hilt.android") version "2.44"
    id("com.google.devtools.ksp")

}

android {
    namespace = "com.example.walkie_talkie"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.walkie_talkie"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt") ,
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }

}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.support.annotations)
    implementation(libs.androidx.material3.android)
    implementation(libs.androidx.runtime.livedata)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    implementation("androidx.compose.material3:material3:1.3.1")
    //KSP
    ksp("androidx.room:room-compiler:2.5.0")
    // Room
    implementation(libs.androidx.room.runtime)
    ksp(libs.androidx.room.compiler)


    // Kotlin Extensions and Coroutines support for Room
    implementation(libs.androidx.room.ktx)

    // Test helpers
    testImplementation(libs.androidx.room.testing)

    // Lifecycle
    implementation(libs.androidx.lifecycle.runtime.ktx)

    // viewModelScope
    implementation(libs.androidx.lifecycle.viewmodel.savedstate)

    //Coil
    implementation(libs.coil)
    implementation(libs.coil.compose)

    //Navigation
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)

    //Retrofit
    implementation(libs.retrofit)
    implementation(libs.converter.gson)

    //HTTP Client
    implementation(libs.okhttp)


    //Hilt
    implementation(libs.hilt.android)
    ksp(libs.com.google.dagger.hilt.compiler2)
    androidTestImplementation(libs.dagger.hilt.android.testing)
    kspAndroidTest(libs.com.google.dagger.hilt.compiler2)
    testImplementation(libs.dagger.hilt.android.testing)
    kspTest(libs.com.google.dagger.hilt.compiler2)

    // Constraints Layout
    implementation(libs.androidx.constraintlayout.compose)


    // ui controller
    implementation(libs.accompanist.systemuicontroller)

    implementation(libs.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)


    implementation(libs.moshi)

    implementation(libs.accompanist.insets)


    // adding the imaginal ai
    implementation(libs.generativeai)

    // adding the camera
    implementation(libs.androidx.camera.core)
    implementation(libs.androidx.camera.camera2)
    // If you want to additionally use the CameraX Lifecycle library
    implementation(libs.androidx.camera.lifecycle)
    // If you want to additionally use the CameraX VideoCapture library
    implementation(libs.androidx.camera.video)
    // If you want to additionally use the CameraX View class
    implementation(libs.androidx.camera.view)
    // If you want to additionally add CameraX ML Kit Vision Integration
    implementation(libs.androidx.camera.mlkit.vision)
    // If you want to additionally use the CameraX Extensions library
    implementation(libs.androidx.camera.extensions)

}



ksp {
    // Optional: Specify arguments for KSP processors
    arg("room.schemaLocation" , "$projectDir/schemas") // Example for Room schema location

}


