package com.cheeruplife.core.designsystem.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.cheeruplife.core.designsystem.common.Dimens
import com.cheeruplife.core.designsystem.theme.LifeGray
import com.cheeruplife.core.designsystem.theme.LifeGray400

@Composable
fun LifeScrollUpFloatingButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    OutlinedIconButton (
        modifier = modifier,
        border = BorderStroke(
            width = Dimens.Size1,
            color = LifeGray400,
        ),
        colors = IconButtonDefaults.iconButtonColors(
            containerColor = Color.White,
            contentColor = LifeGray,
        ),
        onClick = onClick,
    ) {
        Icon(
            modifier = Modifier.rotate(90f),
            imageVector = Icons.AutoMirrored.Rounded.ArrowBack,
            contentDescription = null,
        )
    }
}

@Preview(name = "FloatingButton")
@Composable
private fun PreviewFloatingButton() {
    LifeScrollUpFloatingButton(
        onClick = {},
    )
}