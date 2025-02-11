package com.solid.ufc.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.solid.ufc.ui.components.UFCLogoView
import com.solid.ufc.ui.theme.PrimaryCardColors
import com.solid.ufc.ui.theme.UFCTheme
import com.solid.ufc.ui.utils.onePadding
import com.solid.ufc.ui.R
import com.solid.ufc.ui.utils.UFCPreview
import com.solid.ufc.ui.utils.fourPadding

@Composable
fun SplashScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary)
    ) {
        Card(
            modifier = Modifier
                .onePadding()
                .fillMaxSize(),
            colors = PrimaryCardColors,

        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.weight(1f))
                Spacer(modifier = Modifier.weight(1f))

                UFCLogoView(
                    modifier = Modifier.fillMaxWidth().fourPadding()
                )

                Spacer(modifier = Modifier.weight(1f))

                CircularProgressIndicator( color = ProgressIndicatorDefaults.circularDeterminateTrackColor.copy(alpha = 0.5f))
                Text(
                    stringResource(R.string.loading),
                    style = MaterialTheme.typography.bodyMedium
                )

                Spacer(modifier = Modifier.weight(1f))
            }
        }
    }
}

@Composable
@UFCPreview
fun SplashPage_Preview() {
    UFCTheme {
        SplashScreen()
    }
}