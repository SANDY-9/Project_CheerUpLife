package com.cheeruplife.core.designsystem.component

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.cheeruplife.core.designsystem.common.Dimens
import com.cheeruplife.core.designsystem.common.Margin
import com.cheeruplife.core.designsystem.theme.CheerUpLifeTheme
import com.cheeruplife.core.designsystem.theme.LifeGray700
import com.cheeruplife.core.designsystem.theme.LifeRed
import com.cheeruplife.core.designsystem.theme.Typography

@Composable
fun LifeTextButton(
    title: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    var color: Color by remember { mutableStateOf(LifeRed) }
    Box(
        modifier = modifier.pointerInput(Unit) {
            detectTapGestures(
                onPress = {
                    color = LifeGray700
                },
                onTap = {
                    color = LifeRed
                    onClick()
                }
            )
        }
        ,
    ) {
        Text(
            text = title,
            style = Typography.bodyMedium.copy(
                color = color,
                fontWeight = FontWeight.SemiBold,
            ),
        )
    }
}

@Preview(name = "TextButton")
@Composable
private fun PreviewTextButton() {
    var test by remember { mutableStateOf("전체보기") }
    CheerUpLifeTheme {
        Column {
            LifeTextButton(
                title = test,
                onClick = {
                    test = if(test != "테스트 입니다") "테스트 입니다" else "전체보기"
                }
            )
            Margin(height = Dimens.Margin8)
            LifeTextButton(
                title = "전체보기",
                onClick = {},
            )
        }
    }
}