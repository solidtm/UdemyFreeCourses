package com.solid.ufc.ui.theme

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

object SpacingTheme {
    val oneQuarter = 2.dp
    val oneHalf = 4.dp
    val one = 8.dp
    val two = 16.dp
    val three = 24.dp
    val four = 32.dp
}

object Spacers {
    @Composable
    fun OneQuarterVerticalSpacer() {
        Spacer(modifier = Modifier.height(SpacingTheme.oneQuarter))
    }

    @Composable
    fun OneHalfVerticalSpacer() {
        Spacer(modifier = Modifier.height(SpacingTheme.oneHalf))
    }

    @Composable
    fun OneVerticalSpacer() {
        Spacer(modifier = Modifier.height(SpacingTheme.one))
    }

    @Composable
    fun TwoVerticalSpacer() {
        Spacer(modifier = Modifier.height(SpacingTheme.two))
    }

    @Composable
    fun ThreeVerticalSpacer() {
        Spacer(modifier = Modifier.height(SpacingTheme.three))
    }

    @Composable
    fun FourVerticalSpacer() {
        Spacer(modifier = Modifier.height(SpacingTheme.four))
    }

    @Composable
    fun OneQuarterHorizontalSpacer() {
        Spacer(modifier = Modifier.width(SpacingTheme.oneQuarter))
    }
    @Composable
    fun OneHalfHorizontalSpacer() {
        Spacer(modifier = Modifier.width(SpacingTheme.oneHalf))
    }
    @Composable
    fun OneHorizontalSpacer() {
        Spacer(modifier = Modifier.width(SpacingTheme.one))
    }
    @Composable
    fun TwoHorizontalSpacer() {
        Spacer(modifier = Modifier.width(SpacingTheme.two))
    }
    @Composable
    fun ThreeHorizontalSpacer() {
        Spacer(modifier = Modifier.width(SpacingTheme.three))
    }
    @Composable
    fun FourHorizontalSpacer() {
        Spacer(modifier = Modifier.width(SpacingTheme.four))
    }
}

@Composable
fun ColumnScope.oneQuarterPadding() = Spacers.OneQuarterVerticalSpacer()

@Composable
fun ColumnScope.oneHalfPadding() = Spacers.OneHalfVerticalSpacer()

@Composable
fun ColumnScope.onePadding() = Spacers.OneVerticalSpacer()

@Composable
fun ColumnScope.twoPadding() = Spacers.TwoVerticalSpacer()

@Composable
fun ColumnScope.threePadding() = Spacers.ThreeVerticalSpacer()

@Composable
fun ColumnScope.fourPadding() = Spacers.FourVerticalSpacer()

@Composable
fun RowScope.oneQuarterPadding() = Spacers.OneQuarterHorizontalSpacer()

@Composable
fun RowScope.oneHalfPadding() = Spacers.OneHalfHorizontalSpacer()

@Composable
fun RowScope.onePadding() = Spacers.OneHorizontalSpacer()

@Composable
fun RowScope.twoPadding() = Spacers.TwoHorizontalSpacer()

@Composable
fun RowScope.threePadding() = Spacers.ThreeHorizontalSpacer()

@Composable
fun RowScope.fourPadding() = Spacers.FourHorizontalSpacer()