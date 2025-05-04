package com.cheeruplife.core.designsystem.dragdrop

import androidx.compose.foundation.lazy.LazyListItemInfo
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.geometry.Offset
import kotlinx.coroutines.channels.Channel

class DragAndDropListState (
    val lazyListState: LazyListState,
    private val onMove: (Int, Int) -> Unit,
) {

    val scrollChannel = Channel<Float>()

    var currentIndexOfDraggedItem by mutableStateOf<Int?>(null)
        private set

    private val currentElement: LazyListItemInfo?
        get() = currentIndexOfDraggedItem?.let {
            lazyListState.getVisibleItemInfo(it)
        }

    private var initialDraggingElement by mutableStateOf<LazyListItemInfo?>(null)

    private val initialOffsets: Pair<Int, Int>?
        get() = initialDraggingElement?.let { Pair(it.offset, it.offsetEnd) }

    private var draggingDistance by mutableFloatStateOf(0f)

    val elementDisplacement: Float?
        get() = currentIndexOfDraggedItem
            ?.let { lazyListState.getVisibleItemInfo(it) }
            ?.let { itemInfo ->
                (initialDraggingElement?.offset
                    ?: 0f).toFloat() + draggingDistance - itemInfo.offset
            }

    private val LazyListItemInfo.offsetEnd: Int
        get() = this.offset + this.size

    fun onDragStart(offset: Offset) {
        lazyListState.layoutInfo.visibleItemsInfo
            .firstOrNull { item -> offset.y.toInt() in item.offset..item.offsetEnd }
            ?.also {
                initialDraggingElement = it
                currentIndexOfDraggedItem = it.index
            }
    }

    private fun LazyListState.getVisibleItemInfo(itemPosition: Int): LazyListItemInfo? {
        return this.layoutInfo.visibleItemsInfo.getOrNull(itemPosition - firstVisibleItemIndex)
    }

    fun onDrag(offset: Offset) {
        draggingDistance += offset.y

        initialOffsets?.let { (top, bottom) ->
            val startOffset = top.toFloat() + draggingDistance
            val endOffset = bottom.toFloat() + draggingDistance
            val middleOffset = (startOffset + endOffset) / 2f

            currentElement?.let { current ->
                val targetElement = lazyListState.layoutInfo.visibleItemsInfo.find {
                    middleOffset.toInt() in it.offset..it.offsetEnd && current.index != it.index
                }
                targetElement?.let { target ->
                    currentIndexOfDraggedItem?.let {
                        onMove(it, target.index)
                    }
                    currentIndexOfDraggedItem = target.index
                } ?: checkOverscroll()
            }
        }
    }

    fun checkOverscroll() {
        val overscroll = initialDraggingElement?.let {
            val startOffset = it.offset + draggingDistance
            val endOffset = it.offsetEnd + draggingDistance

            return@let when {
                draggingDistance > 0 -> {
                    (endOffset - lazyListState.layoutInfo.viewportEndOffset).takeIf { diff -> diff > 0 }
                }

                draggingDistance < 0 -> {
                    (startOffset - lazyListState.layoutInfo.viewportStartOffset).takeIf { diff -> diff < 0 }
                }

                else -> null
            }
        } ?: 0f

        if (overscroll != 0f) {
            scrollChannel.trySend(overscroll)
        }
    }

    fun onDragInterrupted() {
        initialDraggingElement = null
        currentIndexOfDraggedItem = null
        draggingDistance = 0f
    }

}


@Composable
fun rememberDragAndDropListState(
    onMove: (Int, Int) -> Unit,
): DragAndDropListState {
    val lazyListState = rememberLazyListState()
    val state = remember(lazyListState) {
        DragAndDropListState(
            lazyListState = lazyListState,
            onMove = onMove,
        )
    }
    return state
}