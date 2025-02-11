plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.daggerHilt)
    alias(libs.plugins.serilazation)
    alias(libs.plugins.parcelize)
    id("kotlin-kapt")
}

android {
    namespace = "com.solid.ufc.data"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)


    implementation(libs.retrofitGson)
    implementation(libs.retrofit)
    implementation(libs.okhttpLogging)
    implementation(libs.hiltNavigation)
    implementation(libs.kotlinxSerialization)
    implementation(libs.composeNav)

    api(libs.daggerHilt)
    kapt(libs.daggerKapt)
    kapt(libs.daggerCompiler)
    kapt(libs.hiltAndroidProcessor)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}

kapt {
    correctErrorTypes = true
}