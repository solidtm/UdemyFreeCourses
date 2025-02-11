plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.daggerHilt)
    alias(libs.plugins.composeCompilier)
    alias(libs.plugins.serilazation)
    alias(libs.plugins.parcelize)
    id("kotlin-kapt")
}

android {
    namespace = "com.solid.ufc"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.solid.ufc"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    api(project(":core:data"))
    api(project(":core:ui"))
    api(project(":features:onboarding"))
    api(project(":features:home"))
    api(project(":features:wishlist"))
    api(project(":features:profile"))
    api(project(":core:data"))
    api(project(":core:ui"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.daggerHilt)
    implementation(libs.lifecycleViewModel)
    implementation(libs.hiltNavigation)
    implementation(libs.lifeCycleCompose)
    implementation(libs.lifecycleViewModel)
    implementation(libs.constraintCompose)
    implementation(libs.coil)
    implementation(libs.coilCompose)
    implementation(libs.kotlinxSerialization)
    kapt(libs.daggerKapt)
    kapt(libs.daggerCompiler)
    kapt(libs.hiltAndroidProcessor)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}