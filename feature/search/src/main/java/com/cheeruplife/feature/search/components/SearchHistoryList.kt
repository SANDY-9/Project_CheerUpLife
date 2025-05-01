package com.cheeruplife.feature.search.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.cheeruplife.core.designsystem.common.Dimens
import com.cheeruplife.core.designsystem.component.LifeOutlineClearButton
import com.cheeruplife.core.designsystem.theme.CheerUpLifeTheme

@Composable
internal fun SearchHistoryList(
    historyList: List<String>,
    onSearch: (String) -> Unit,
    onClear: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    FlowRow(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(Dimens.Margin8),
    ) {
        historyList.forEach { item ->
            val clickEvent = remember {
                { onSearch(item) }
            }
            val clearEvent = remember {
                { onClear(item) }
            }
            HistoryItem(
                title = item,
                onClick = clickEvent,
                onClear = clearEvent,
            )
        }
    }
}

@Composable
private fun HistoryItem(
    title: String,
    onClick: () -> Unit,
    onClear: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier.padding(bottom = Dimens.Margin10),
    ) {
        LifeOutlineClearButton(
            title = title,
            onClick = onClick,
            onClear = onClear,
        )
    }
}

@Preview(name = "SearchHistoryList")
@Composable
private fun PreviewSearchHistoryList() {
    val testList = List(20) { index ->
        when {
            index % 2 == 0 -> {
                if(index % 4 == 0) {
                    "태그"
                } else {
                    "이상한 나라의 앨리스"
                }
            }
            index % 3 == 0 -> "History"
            else -> "개발자"
        }
    }
    CheerUpLifeTheme {
        SearchHistoryList(
            historyList = testList,
            onSearch = { },
            onClear = { },
        )
    }
}