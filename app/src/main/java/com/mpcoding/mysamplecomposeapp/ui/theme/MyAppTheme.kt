package com.mpcoding.mysamplecomposeapp.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun MyAppTheme(content: @Composable () -> Unit) {
    MaterialTheme(colors = ColorPalette, typography = Typography, content = content)
}