package com.solid.ufc.onboarding

import android.app.Application
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.solid.ufc.data.module.CoreDataComponent
import com.solid.ufc.onboarding.ui.OnboardingScreen
import com.solid.ufc.onboarding.ui.OnboardingViewModel
import com.solid.ufc.ui.interfaces.UFCNavRoutes
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Component(
    modules = [OnboardingModule::class],
    dependencies = [CoreDataComponent::class]
)
interface OnboardingComponent {
    fun inject(app: Application)

    @Component.Builder
    interface Builder {
        fun coreDataComponent(coreDataComponent: CoreDataComponent): Builder
        fun context(@BindsInstance app: Application): Builder
        fun build(): OnboardingComponent
    }
}

@Module
@InstallIn(ViewModelComponent::class)
class OnboardingModule {
    @Provides
    fun provideOnboardingViewModel(
    ): OnboardingViewModel {
        return OnboardingViewModel()
    }
}

fun NavGraphBuilder.onboarding() {
    composable(UFCNavRoutes.ONBOARDING.route) {
        OnboardingScreen()
    }
}