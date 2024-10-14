package com.solid.udemyfreecourses.ui.utils

import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview

@Preview(
    name = "Small Device",
    showSystemUi = true,
    device = Devices.PIXEL_3A
)

@Preview(
    name = "Large Device",
    showSystemUi = true,
    device = Devices.PIXEL_4_XL
)

annotation class UdemyFreeCoursesPreview