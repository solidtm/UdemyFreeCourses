package com.solid.ufc.ui.utils

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
    device = Devices.PIXEL_7_PRO
)

annotation class UFCPreview