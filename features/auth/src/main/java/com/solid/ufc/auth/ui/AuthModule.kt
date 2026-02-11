package com.solid.ufc.auth.ui

import android.app.Application
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.solid.ufc.data.module.CoreDataComponent
import com.solid.ufc.ui.interfaces.UFCNavRoutes
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Component(
    modules = [AuthModule::class],
    dependencies = [CoreDataComponent::class]
)
interface AuthComponent {
    fun inject(app: Application)

    @Component.Builder
    interface Builder {
        fun coreDataComponent(coreDataComponent: CoreDataComponent): Builder
        fun context(@BindsInstance app: Application): Builder
        fun build(): AuthComponent
    }
}

@Module
@InstallIn(ViewModelComponent::class)
class AuthModule {

}

fun NavGraphBuilder.auth(
    navController: NavController
) {
    composable(UFCNavRoutes.SIGNUP.route) {
        SignUpScreen()
    }
}