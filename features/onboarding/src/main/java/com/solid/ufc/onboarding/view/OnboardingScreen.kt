package com.solid.ufc.onboarding.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.solid.ufc.onboarding.viewmodel.OnboardingViewModel
import com.solid.ufc.ui.R
import com.solid.ufc.ui.theme.PrimaryCardColors
import com.solid.ufc.ui.theme.UFCTheme
import com.solid.ufc.ui.utils.UFCPreview
import com.solid.ufc.ui.utils.onePadding

@Composable
fun OnboardingScreen(
    viewModel: OnboardingViewModel,
    rootNavController: NavController
) {
    LaunchedEffect("goToHome") {
//        viewModel.goToHome(rootNavController) //you can comment this out when you want to implement going to the home screen
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Card(
            modifier = Modifier
                .onePadding()
                .fillMaxSize(),
            colors = PrimaryCardColors.copy(containerColor = MaterialTheme.colorScheme.background),

            ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {


                Spacer(modifier = Modifier.weight(1f))

                Text(
                    stringResource(R.string.onboard),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.scrim
                )

                Spacer(modifier = Modifier.weight(1f))
            }
        }
    }
}

@Composable
@UFCPreview
fun OnboardingScreenPreview() {
    UFCTheme {
        OnboardingScreen(
            viewModel = OnboardingViewModel(),
            rootNavController = NavController(LocalContext.current)
        )
    }
}