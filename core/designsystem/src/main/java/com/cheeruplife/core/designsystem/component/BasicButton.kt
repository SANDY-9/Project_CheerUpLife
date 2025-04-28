package com.cheeruplife.core.designsystem.component

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.cheeruplife.core.designsystem.common.RoundSquare
import com.cheeruplife.core.designsystem.theme.CheerUpLifeTheme
import com.cheeruplife.core.designsystem.theme.Typography

@Composable
fun LifeButton(
    title: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        shape = RoundSquare.Regular,
    ) {
        Text(
            text = title,
            style = Typography.bodyLarge.copy(
                color = Color.White,
                fontWeight = FontWeight.Bold,
            ),
        )
    }
}

@Preview(name = "Button")
@Composable
private fun PreviewButton() {
    CheerUpLifeTheme {
        Column {
            LifeButton(
                title = "Button 버튼타이틀",
                onClick = {},
            )
            LifeButton(
                title = "Button 버튼타이틀",
                onClick = {},
            )
        }
    }
}