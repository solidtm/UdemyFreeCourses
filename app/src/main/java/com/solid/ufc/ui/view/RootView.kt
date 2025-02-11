package com.solid.ufc.ui.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.solid.ufc.home.SplashScreen
import com.solid.ufc.home.viewmodel.HomeViewModel
import com.solid.ufc.onboarding.module.onboarding
import com.solid.ufc.ui.interfaces.UFCNavRoutes

@Composable
fun HomeRootView() {
    val navController = rememberNavController()
    val viewmodel = viewModel<HomeViewModel>()

    LaunchedEffect("checkAuthStatus") {
        viewmodel.watchAuthStatus(navController)
    }

    NavHost(
        navController = navController,
        startDestination = UFCNavRoutes.SPLASH.route
    ) {
        composable(UFCNavRoutes.SPLASH.route) {
            SplashScreen()
        }

        composable(UFCNavRoutes.HOME.route) {
        }

        onboarding(
            rootNaveController = navController
        )
//
//        profile(navController = navController)
//
//        question(navController)
//
//        wishlist()

        composable(UFCNavRoutes.ERROR.route) {
        }
    }
}