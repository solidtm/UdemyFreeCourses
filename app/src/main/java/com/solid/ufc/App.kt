package com.solid.ufc

import android.app.Application
import com.solid.ufc.data.module.DaggerCoreDataComponent
import com.solid.ufc.module.DaggerAppComponent
import com.solid.ufc.onboarding.module.DaggerOnboardingComponent
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {

    override fun onCreate() {
        super.onCreate()

        val coreDataComponent = DaggerCoreDataComponent.builder()
            .context(this)
            .build()

        val onboardingComponent = DaggerOnboardingComponent.builder()
            .coreDataComponent(coreDataComponent)
            .context(this)
            .build()

//        val authComponent = DaggerAuthComponent.builder()
//            .coreDataComponent(coreDataComponent)
//            .context(this)
//            .build()
//        authComponent.inject(this)

//
//        val profileComponent = DaggerProfileComponent.builder()
//            .coreDataComponent(coreDataComponent)
//            .context(this)
//            .build()
//
//        val homeComponent = DaggerHomeComponent.builder()
//            .coreDataComponent(coreDataComponent)
//            .context(this)
//            .build()
//
//        val wishlistComponent = DaggerWishlistComponent.builder()
//            .coreDataComponent(coreDataComponent)
//            .context(this)
//            .build()

        DaggerAppComponent.builder()
            .application(this)
            .coreDataComponent(coreDataComponent)
            .onboardingComponent(onboardingComponent)
//            .authComponent(authComponent)
//            .profileComponent(profileComponent)
//            .homeComponent(homeComponent)
//            .wishlistComponent(wishlistComponent)
            .build()
            .inject(this)
    }
}