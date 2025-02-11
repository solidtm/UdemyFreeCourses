package com.solid.ufc.onboarding.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.solid.ufc.ui.interfaces.UFCNavRoutes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor() : ViewModel() {

    fun goToHome(navController: NavController) {
        viewModelScope.launch {
            delay(1000)
            navController.navigate(UFCNavRoutes.HOME.route) {
                popUpTo(UFCNavRoutes.SPLASH.route) {
                    inclusive = true
                }
            }
        }
    }
}