package com.solid.ufc.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.solid.ufc.ui.interfaces.UFCNavRoutes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
) : ViewModel() {

    fun watchAuthStatus(
        navController: NavController
    ) {
        viewModelScope.launch {
            delay(3000)
            navController.navigate(UFCNavRoutes.ONBOARDING.route)
        }
    }
}