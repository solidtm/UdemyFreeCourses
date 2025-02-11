package com.solid.ufc.ui.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.solid.ufc.ui.R
import com.solid.ufc.ui.theme.UFCTheme
import com.solid.ufc.ui.utils.UFCPreview

@Composable
fun UFCLogoView(
    modifier: Modifier = Modifier
) {
    Image(
        modifier = modifier,
        painter = painterResource(id = R.drawable.ufc_logo),
        contentDescription = "UFC",
        contentScale = ContentScale.Crop
    )
}