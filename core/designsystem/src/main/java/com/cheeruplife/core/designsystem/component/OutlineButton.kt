package com.cheeruplife.core.designsystem.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cheeruplife.core.designsystem.theme.CheerUpLifeTheme
import com.cheeruplife.core.designsystem.theme.LifeGray
import com.cheeruplife.core.designsystem.theme.LifeGray400
import com.cheeruplife.core.designsystem.theme.LifeGray700
import com.cheeruplife.core.designsystem.theme.Typography

@Composable
fun LifeOutlineDropDownButton(
    title: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    OutlinedButton(
        modifier = modifier.defaultMinSize(
            minHeight = 1.dp,
            minWidth = 1.dp,
        ),
        onClick = onClick,
        border = BorderStroke(
            width = 1.dp,
            color = LifeGray400,
        ),
        contentPadding = PaddingValues(
            vertical = 4.dp,
            horizontal = 10.dp,
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
                    width = 16.dp,
                    height = 8.dp,
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
    onClear: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
) {
    var visible by rememberSaveable { mutableStateOf(true) }
    if(visible) {
        OutlinedButton(
            modifier = modifier.defaultMinSize(
                minHeight = 1.dp,
                minWidth = 1.dp
            ),
            onClick = onClick,
            border = BorderStroke(
                width = 1.dp,
                color = LifeGray400,
            ),
            contentPadding = PaddingValues(
                vertical = 4.dp,
                horizontal = 12.dp,
            )
        ) {
            Text(
                text = title,
                style = Typography.bodyMedium.copy(
                    color = LifeGray,
                    fontWeight = FontWeight.Medium,
                ),
            )
            Spacer(modifier = modifier.width(2.dp))
            Icon(
                modifier = modifier.size(16.dp)
                    .clickable{
                        visible = false
                        onClear(true)
                    },
                imageVector = Icons.Rounded.Clear,
                contentDescription = null,
                tint = LifeGray700,
            )
        }
    }
}

@Preview(name = "OutlineButton")
@Composable
private fun PreviewOutlineButton() {
    CheerUpLifeTheme {
        Column {
            LifeOutlineDropDownButton(
                title = "Button 버튼타이틀",
                onClick = {},
            )
            Spacer(modifier = Modifier.height(8.dp))
            LifeOutlineClearButton(
                title = "Button 버튼타이틀",
                onClick = {},
                onClear = {},
            )
        }
    }
}