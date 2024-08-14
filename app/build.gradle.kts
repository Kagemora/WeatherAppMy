plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("kotlin-parcelize")
    id("kotlin-kapt")
    id("androidx.navigation.safeargs")
}

android {
    namespace = "com.example.weatherappmy"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.weatherappmy"
        minSdk = 28
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    //WorkManager
    implementation(libs.androidx.work.runtime.ktx)

    //Network
    implementation(libs.gson)
    implementation(libs.converter.gson)
    implementation(libs.retrofit)
    implementation(libs.okhttp3.okhttp)
    implementation(libs.okhttp3.logging.interceptor)

    //Coroutines
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)

    //Room cache
    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.legacy.support.v4)
    implementation(libs.androidx.fragment.ktx)
    kapt(libs.androidx.room.compiler)
    implementation(libs.androidx.room.ktx)

    //UI
    implementation(libs.androidx.recyclerview)
    implementation(libs.androidx.recyclerview.selection)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.cardview)

    //Jp Nav
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)

    //Picasso/Glide
    implementation(libs.picasso)
    implementation(libs.glide)
    kapt(libs.compiler)

    //Dagger2
    implementation(libs.dagger.android)
    implementation(libs.dagger.android.support)
    kapt(libs.google.dagger.android.processor)
    kapt(libs.google.dagger.compiler)

    // view binding property delegate
    implementation(libs.viewbindingpropertydelegate.full)
    implementation(libs.viewbindingpropertydelegate.noreflection)

    //Test
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    //Permissions
    implementation(libs.dexter)

    //OutOfMemoryError
    implementation(libs.leakcanary.android)
}