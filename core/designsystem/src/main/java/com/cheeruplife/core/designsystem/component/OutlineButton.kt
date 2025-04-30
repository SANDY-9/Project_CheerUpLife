package com.cheeruplife.core.designsystem.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.cheeruplife.core.designsystem.common.Dimens
import com.cheeruplife.core.designsystem.common.Margin
import com.cheeruplife.core.designsystem.common.RoundSquare
import com.cheeruplife.core.designsystem.theme.CheerUpLifeTheme
import com.cheeruplife.core.designsystem.theme.LifeGray
import com.cheeruplife.core.designsystem.theme.LifeGray400
import com.cheeruplife.core.designsystem.theme.LifeGray700
import com.cheeruplife.core.designsystem.theme.Typography

@Composable
fun LifeOutLineButton(
    onClick: () -> Unit,
    content: @Composable (RowScope.() -> Unit),
    modifier: Modifier = Modifier,
) {
    OutlinedButton(
        modifier = modifier.defaultMinSize(
            minHeight = Dimens.Size1,
            minWidth = Dimens.Size1,
        ),
        onClick = onClick,
        shape = RoundSquare.Regular,
        border = BorderStroke(
            width = Dimens.Size1,
            color = LifeGray400,
        ),
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = Color.White,
            contentColor = LifeGray,
        ),
        contentPadding = PaddingValues(
            vertical = Dimens.Margin4,
        ),
        content = content,
    )
}

@Composable
fun LifeOutLineButton(
    title: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    OutlinedButton(
        modifier = modifier.defaultMinSize(
            minHeight = Dimens.Size1,
            minWidth = Dimens.Size1,
        ),
        onClick = onClick,
        shape = RoundSquare.Regular,
        border = BorderStroke(
            width = Dimens.Size1,
            color = LifeGray400,
        ),
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = Color.White,
            contentColor = LifeGray,
        ),
        contentPadding = PaddingValues(
            vertical = Dimens.Margin4,
            horizontal = Dimens.Margin10,
        ),
    ) {
        Text(
            text = title,
            style = Typography.bodyLarge.copy(
                fontWeight = FontWeight.Bold,
            ),
        )
    }
}

@Composable
fun LifeOutlineDropDownButton(
    title: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    OutlinedButton(
        modifier = modifier.defaultMinSize(
            minHeight = Dimens.Size1,
            minWidth = Dimens.Size1,
        ),
        onClick = onClick,
        border = BorderStroke(
            width = Dimens.Size1,
            color = LifeGray400,
        ),
        contentPadding = PaddingValues(
            vertical = Dimens.Margin4,
            horizontal = Dimens.Margin10,
        ),
    ) {
        Text(
            text = title,
            style = Typography.bodySmall.copy(
                color = LifeGray,
                fontWeight = FontWeight.Medium,
            ),
        )
        Image(
            modifier = modifier.size(
                    width = Dimens.Size16,
                    height = Dimens.Size8,
                ),
            imageVector = Icons.Rounded.KeyboardArrowDown,
            contentScale = ContentScale.FillWidth,
            colorFilter = ColorFilter.tint(
                color = LifeGray700,
            ),
            contentDescription = null,
        )
    }
}

@Composable
fun LifeOutlineClearButton(
    title: String,
    onClick: () -> Unit,
    onClear: () -> Unit,
    modifier: Modifier = Modifier,
) {
    OutlinedButton(
        modifier = modifier.defaultMinSize(
            minHeight = Dimens.Size1,
            minWidth = Dimens.Size1,
        ),
        onClick = onClick,
        border = BorderStroke(
            width = Dimens.Size1,
            color = LifeGray400,
        ),
        contentPadding = PaddingValues(
            vertical = Dimens.Margin4,
            horizontal = Dimens.Margin12,
        )
    ) {
        Text(
            text = title,
            style = Typography.bodyMedium.copy(
                color = LifeGray,
                fontWeight = FontWeight.Medium,
            ),
        )
        Margin(width = Dimens.Margin2)
        Icon(
            modifier = modifier.size(Dimens.Size16)
                .clickable(
                    onClick = onClear,
                ),
            imageVector = Icons.Rounded.Clear,
            contentDescription = null,
            tint = LifeGray700,
        )
    }
}

@Preview(name = "OutlineButton")
@Composable
private fun PreviewOutlineButton() {
    CheerUpLifeTheme {
        Column {
            LifeOutLineButton(
                title = "Button 버튼타이틀",
                onClick = {},
            )
            Margin(height = Dimens.Margin8)
            LifeOutlineDropDownButton(
                title = "Button 버튼타이틀",
                onClick = {},
            )
            Margin(height = Dimens.Margin8)
            LifeOutlineClearButton(
                title = "Button 버튼타이틀",
                onClick = {},
                onClear = {},
            )
        }
    }
}