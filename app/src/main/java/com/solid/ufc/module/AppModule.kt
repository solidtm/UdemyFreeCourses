package com.solid.ufc.module

import android.app.Application
import com.solid.ufc.data.module.CoreDataComponent
import com.solid.ufc.onboarding.module.OnboardingComponent
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Component(
    modules = [
        AppModule::class
    ],
    dependencies = [
        CoreDataComponent::class,
        OnboardingComponent::class,
//        AuthComponent::class,
//        ProfileComponent::class,
//        HomeComponent::class,
//        WishListComponent::class
    ]
)
abstract class AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun coreDataComponent(coreDataComponent: CoreDataComponent): Builder
        fun onboardingComponent(onboardingComponent: OnboardingComponent): Builder
//        fun authComponent(authComponent: AuthComponent): Builder
//        fun profileComponent(profileComponent: ProfileComponent): Builder
//        fun homeComponent(homeComponent: HomeComponent): Builder
//        fun wishListComponent(wishListComponent: WishListComponent): Builder
        fun build(): AppComponent
    }

    abstract fun inject(app: Application)
}

@Module
@InstallIn(ViewModelComponent::class)
class AppModule {

}
