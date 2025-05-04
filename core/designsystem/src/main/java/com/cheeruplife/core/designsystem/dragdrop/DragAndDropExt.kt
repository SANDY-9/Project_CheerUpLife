package com.cheeruplife.core.designsystem.dragdrop

import androidx.compose.foundation.gestures.detectDragGesturesAfterLongPress
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.zIndex

fun <T> MutableList<T>.move(from: Int, to: Int) {
    if (from == to) return
    val element = this.removeAt(from)
    this.add(to, element)
}

fun Modifier.dragContainer(
    dragAndDropListState: DragAndDropListState,
): Modifier {
    return this.pointerInput(Unit) {
        detectDragGesturesAfterLongPress(
            onDrag = { change, offset ->
                change.consume()
                dragAndDropListState.onDrag(offset)
            },
            onDragStart = dragAndDropListState::onDragStart,
            onDragEnd = dragAndDropListState::onDragInterrupted,
            onDragCancel = dragAndDropListState::onDragInterrupted,
        )
    }
}


@Composable
fun LazyItemScope.DraggableItem(
    dragAndDropListState: DragAndDropListState,
    index: Int,
    content: @Composable LazyItemScope.(Modifier) -> Unit,
) {
    val isDragging = index == dragAndDropListState.currentIndexOfDraggedItem
    val offsetOrNull = dragAndDropListState.elementDisplacement.takeIf { isDragging }
    val draggingModifier = Modifier
        .composed {
            Modifier.graphicsLayer {
                translationY = offsetOrNull ?: 0f
            }
        }
        .zIndex(if (isDragging) 1f else 0f)
        .graphicsLayer {
            translationY = offsetOrNull ?: 0f
            scaleX = if (isDragging) 1.05f else 1f
            scaleY = if (isDragging) 1.05f else 1f
        }
    content(draggingModifier)
}