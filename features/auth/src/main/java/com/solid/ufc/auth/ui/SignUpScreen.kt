package com.solid.ufc.auth.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.solid.ufc.ui.utils.UFCPreview

@Composable
fun SignUpScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(),
            text = "This is the sign up  screen"
        )
    }
}


@UFCPreview
@Composable
fun SignUpScreenPreview(){
    SignUpScreen()
}