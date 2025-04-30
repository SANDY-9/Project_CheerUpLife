package com.cheeruplife.core.designsystem.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.LayoutCoordinates
import androidx.compose.ui.layout.boundsInParent
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.tooling.preview.Preview
import com.cheeruplife.core.designsystem.common.Dimens
import com.cheeruplife.core.designsystem.theme.Typography
import com.cheeruplife.core.resources.icons.MyIconPack
import com.cheeruplife.core.resources.icons.myiconpack.Event

@Composable
fun LifeTouchReactiveMenu(
    icon: ImageVector,
    label: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    var scale by remember { mutableFloatStateOf(1f) }
    var targetBounds by remember { mutableStateOf<Rect?>(null) }
    val measureEvent = remember {
        { coordinates: LayoutCoordinates -> targetBounds = coordinates.boundsInParent() }
    }
    Box(
        modifier = modifier.pointerInput(Unit) {
            awaitPointerEventScope {
                while (true) {
                    val change = awaitPointerEvent().changes.first()
                    val isNotOutsideTouch = targetBounds?.contains(change.position) ?: false
                    scale = when {
                        isNotOutsideTouch -> if(change.pressed) 0.9f else 1f.also { onClick() }
                        else -> 1f
                    }
                }
            }
        },
    ) {
        Column (
            modifier = modifier.onGloballyPositioned(onGloballyPositioned = measureEvent),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Box(
                modifier = modifier
                    .size(Dimens.Size54)
                    .padding(Dimens.Margin8)
            ) {
                Image(
                    modifier = modifier.scale(scale),
                    imageVector = icon,
                    contentDescription = null,
                )
            }
            Text(
                text = label,
                style = Typography.bodyMedium,
            )
        }
    }
}

@Preview(name = "TouchReactiveMenu")
@Composable
private fun PreviewTouchReactiveMenu() {
    LifeTouchReactiveMenu(
        icon = MyIconPack.Event,
        label = "Home",
        onClick = {},
    )
}