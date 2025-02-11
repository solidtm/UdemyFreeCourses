package com.solid.ufc.ui.utils

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.solid.ufc.ui.theme.SpacingTheme

fun Modifier.oneQuarterPadding() = this.padding(SpacingTheme.oneQuarter)
fun Modifier.oneHalfPadding() = this.padding(SpacingTheme.oneHalf)
fun Modifier.onePadding() = this.padding(SpacingTheme.one)
fun Modifier.twoPadding() = this.padding(SpacingTheme.two)
fun Modifier.threePadding() = this.padding(SpacingTheme.three)
fun Modifier.fourPadding() = this.padding(SpacingTheme.four)

fun Modifier.oneQuarterVerticalPadding() = this.padding(vertical = SpacingTheme.oneQuarter)
fun Modifier.oneHalfVerticalPadding() = this.padding(vertical = SpacingTheme.oneHalf)
fun Modifier.oneVerticalPadding() = this.padding(vertical = SpacingTheme.one)
fun Modifier.twoVerticalPadding() = this.padding(vertical = SpacingTheme.two)
fun Modifier.threeVerticalPadding() = this.padding(vertical = SpacingTheme.three)
fun Modifier.fourVerticalPadding() = this.padding(vertical = SpacingTheme.four)

fun Modifier.oneQuarterHorizontalPadding() = this.padding(horizontal = SpacingTheme.oneQuarter)
fun Modifier.oneHalfHorizontalPadding() = this.padding(horizontal = SpacingTheme.oneHalf)
fun Modifier.oneHorizontalPadding() = this.padding(horizontal = SpacingTheme.one)
fun Modifier.twoHorizontalPadding() = this.padding(horizontal = SpacingTheme.two)
fun Modifier.threeHorizontalPadding() = this.padding(horizontal = SpacingTheme.three)
fun Modifier.fourHorizontalPadding() = this.padding(horizontal = SpacingTheme.four)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MaterialTheme.topAppBarColors(): TopAppBarColors {
    return TopAppBarColors(
        containerColor = colorScheme.secondaryContainer,
        titleContentColor = colorScheme.onSecondaryContainer,
        navigationIconContentColor = colorScheme.onSecondaryContainer,
        actionIconContentColor = colorScheme.onSecondaryContainer,
        scrolledContainerColor = colorScheme.onSecondaryContainer
    )
}