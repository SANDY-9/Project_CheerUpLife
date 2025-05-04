package com.cheeruplife.core.designsystem.dragdrop

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun <T>LifeDragAndDropListView(
    item: List<T>,
    onPositionChange: (Int, Int) -> Unit,
    content: @Composable (LazyItemScope.(Modifier, T) -> Unit),
) {
    val listItem = remember { item.toMutableStateList() }
    val dragAndDropListState =
        rememberDragAndDropListState { from, to ->
            listItem.move(from, to)
            onPositionChange(from, to)
        }
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .dragContainer(
                dragAndDropListState = dragAndDropListState,
            ),
        state = dragAndDropListState.lazyListState,
    ) {
        itemsIndexed(listItem) { index: Int, item: T ->
            DraggableItem(
                dragAndDropListState = dragAndDropListState,
                index = index,
            ) { modifier ->
                content(modifier, item)
            }
        }
    }
}

@Preview(name = "DragAndDropListView")
@Composable
private fun PreviewDragAndDropListView() {
    val list = listOf("1", "2", "3", "4", "5")
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        LifeDragAndDropListView(
            item = list,
            onPositionChange = { from: Int, to: Int ->

            },
        ) { modifier, item ->
            Box(
                modifier = modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center,
            ) {
                Text("테스트 $item")
            }
        }
    }
}