package com.cheeruplife.core.designsystem.common

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp

@Composable
fun Margin(
    modifier: Modifier = Modifier,
    width: Dp = Dimens.Margin0,
    height: Dp = Dimens.Margin0,
) {
    Spacer(
        modifier = modifier.size(
            width = width,
            height = height,
        )
    )
}
