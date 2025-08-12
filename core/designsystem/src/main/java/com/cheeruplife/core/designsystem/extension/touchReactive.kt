package com.cheeruplife.core.designsystem.extension

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.scale
import androidx.compose.ui.input.pointer.pointerInput

fun Modifier.touchReactive(onClick: () -> Unit): Modifier = composed {
    var scale by remember { mutableFloatStateOf(1f) }
    pointerInput(Unit) {
        awaitPointerEventScope {
            while (true) {
                val change = awaitPointerEvent().changes.first()
                scale = if (change.pressed) 0.9f else 1f.also { onClick() }
            }
        }
    }.scale(scale)
}