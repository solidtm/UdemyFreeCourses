package com.solid.ufc.onboarding.view

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.solid.ufc.onboarding.viewmodel.OnboardingPage
import com.solid.ufc.onboarding.viewmodel.OnboardingViewModel
import com.solid.ufc.ui.utils.UFCPreview

@Composable
fun OnboardingView(
    vm: OnboardingViewModel,
    rootNavController: NavController
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = OnboardingPage.ABOUT_APP.route
    ) {
        composable(OnboardingPage.ABOUT_APP.route) {
            OnboardingScreen(
                vm,
                navController
            )
        }
    }
}

@Composable
@UFCPreview
fun OnboardingPreview() {
    OnboardingView(
        vm = OnboardingViewModel(),
        rootNavController = NavController(LocalContext.current)
    )
}