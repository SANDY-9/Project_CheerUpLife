package com.cheeruplife.core.designsystem.component

import androidx.compose.foundation.gestures.awaitEachGesture
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.pointer.pointerInput

@Composable
fun LifeTouchDetectContainer(
    content: @Composable (touchOffset: Offset?) -> Unit,
) {
    var touchOffset by remember { mutableStateOf<Offset?>(null) }
    Column (
        modifier = Modifier
            .pointerInput(Unit) {
                awaitEachGesture {
                    touchOffset = awaitPointerEvent().changes.first().position
                }
            },
    ) {
        content(touchOffset)
    }
}