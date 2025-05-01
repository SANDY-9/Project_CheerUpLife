package com.cheeruplife.core.designsystem.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.cheeruplife.core.designsystem.common.Dimens
import com.cheeruplife.core.designsystem.common.Margin
import com.cheeruplife.core.designsystem.theme.LifeGray400

@Composable
fun LifeCheckButtonControlView(
    controlSelect: Boolean,
    itemList: List<String>,
    itemSelectMap: Map<String, Boolean>,
    onControlSelectChange: (Boolean) -> Unit,
    onItemSelectChange: (String, Boolean) -> Unit,
    modifier: Modifier = Modifier,
) {
    val lazyListState = rememberLazyListState()
    LaunchedEffect(controlSelect) {
        lazyListState.animateScrollToItem(0)
    }
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        LifeCheckButton(
            title = "전체보기",
            selected = controlSelect,
            onSelectChange = onControlSelectChange,
        )
        Margin(width = Dimens.Margin12)
        VerticalDivider(
            modifier = Modifier.height(Dimens.Size20),
            color = LifeGray400,
        )
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            state = lazyListState,
            horizontalArrangement = Arrangement.spacedBy(Dimens.Margin10),
            contentPadding = PaddingValues(
                start = Dimens.Margin12,
                end = Dimens.Margin16,
            ),
        ) {
            items(itemList) { item ->
                val itemSelectChangeEvent = remember {
                    { selected: Boolean ->
                        onItemSelectChange(item, selected)
                    }
                }
                LifeOutlineCheckButton(
                    title = item,
                    selected = itemSelectMap[item] ?: false,
                    onSelectChange = itemSelectChangeEvent,
                )
            }
        }
    }
}

@Preview(name = "ButtonControlView")
@Composable
private fun PreviewButtonControlView() {
    var controlSelect by remember { mutableStateOf(true) }
    val itemList = remember {
        listOf("itemitemitem1", "item2", "itemitem3", "item3", "item4", "item5")
    }
    var itemSelectMap by remember {
        mutableStateOf(
            itemList.associateWith { true }
        )
    }
    val controlSelectChangeEvent = remember {
        { selected: Boolean ->
            controlSelect = selected
            itemSelectMap = itemList.associateWith { selected }
        }
    }
    val itemSelectChangeEvent = remember {
        { item: String, selected: Boolean ->
            val newMap = itemSelectMap.toMutableMap()
            newMap[item] = selected
            itemSelectMap = newMap.toMap()
            if(!selected) {
                controlSelect = false
            }
            if(!itemSelectMap.containsValue(false)) {
                controlSelect = true
            }
        }
    }
    LifeCheckButtonControlView(
        controlSelect = controlSelect,
        itemList = itemList,
        itemSelectMap = itemSelectMap,
        onControlSelectChange = controlSelectChangeEvent,
        onItemSelectChange = itemSelectChangeEvent,
    )
}