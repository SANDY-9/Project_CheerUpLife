package com.cheeruplife.core.designsystem.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.LayoutCoordinates
import androidx.compose.ui.layout.boundsInParent
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.cheeruplife.core.designsystem.common.Dimens
import com.cheeruplife.core.designsystem.common.Margin
import com.cheeruplife.core.designsystem.theme.CheerUpLifeTheme
import com.cheeruplife.core.designsystem.theme.LifeGray
import com.cheeruplife.core.designsystem.theme.LifeGray700
import com.cheeruplife.core.designsystem.theme.LifeRed
import com.cheeruplife.core.designsystem.theme.Typography

@Composable
fun LifeTextButton(
    title: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    var targetBounds by remember { mutableStateOf<Rect?>(null) }
    val measureEvent = remember {
        { coordinates: LayoutCoordinates -> targetBounds = coordinates.boundsInParent() }
    }
    var color: Color by remember { mutableStateOf(LifeRed) }

    Box(
        modifier = modifier.pointerInput(Unit) {
            awaitPointerEventScope {
                while (true) {
                    val change = awaitPointerEvent().changes.first()
                    val isNotOutsideTouch = targetBounds?.contains(change.position) ?: false
                    color = when {
                        isNotOutsideTouch -> if(change.pressed) LifeGray700 else LifeRed.also {
                            onClick()
                        }
                        else -> LifeRed
                    }
                }
            }
        },
    ) {
        Text(
            modifier = modifier.onGloballyPositioned(onGloballyPositioned = measureEvent),
            text = title,
            style = Typography.bodyMedium.copy(
                color = color,
                fontWeight = FontWeight.SemiBold,
            ),
        )
    }
}

@Composable
fun LifeTextDropdownButton(
    title: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    var targetBounds by remember { mutableStateOf<Rect?>(null) }
    val measureEvent = remember {
        { coordinates: LayoutCoordinates -> targetBounds = coordinates.boundsInParent() }
    }
    var color: Color by remember { mutableStateOf(LifeRed) }

    Box(
        modifier = modifier.pointerInput(Unit) {
            awaitPointerEventScope {
                while (true) {
                    val change = awaitPointerEvent().changes.first()
                    val isNotOutsideTouch = targetBounds?.contains(change.position) ?: false
                    color = when {
                        isNotOutsideTouch -> if(change.pressed) LifeGray700 else LifeRed.also {
                            onClick()
                        }
                        else -> LifeRed
                    }
                }
            }
        },
    ) {
        Row(
            modifier = modifier.onGloballyPositioned(onGloballyPositioned = measureEvent),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = title,
                style = Typography.bodySmall.copy(
                    color = color,
                    fontWeight = FontWeight.Bold,
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
                    color = color
                ),
                contentDescription = null,
            )
        }
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
                onClick = remember {
                    {
                        test = if(test != "테스트 입니다") "테스트 입니다" else "전체보기"
                    }
                }
            )
            Margin(height = Dimens.Margin8)
            LifeTextButton(
                title = "전체보기",
                onClick = {},
            )
            LifeTextDropdownButton(
                title = "전체보기",
                onClick = {},
            )
        }
    }
}