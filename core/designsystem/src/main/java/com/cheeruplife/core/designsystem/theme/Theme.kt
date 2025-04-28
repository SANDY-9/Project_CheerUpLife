package com.cheeruplife.core.designsystem.theme

import androidx.compose.material3.LocalMinimumInteractiveComponentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.unit.dp

private val CheerUpColorScheme = lightColorScheme(
    primary = LifeRed,
    background = White,
    surface = White,
    surfaceTint = White,
    onPrimary = LifeBlack,
    onBackground = LifeBlack,
    onSurface = LifeBlack,
)

@Composable
fun CheerUpLifeTheme(
    content: @Composable () -> Unit
) {
    val colorScheme = CheerUpColorScheme
    CompositionLocalProvider(
        LocalMinimumInteractiveComponentSize provides 1.dp
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = Typography,
            content = content
        )
    }
}