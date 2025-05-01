package com.cheeruplife.feature.search

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.cheeruplife.core.designsystem.extension.addFocusCleaner
import com.cheeruplife.core.designsystem.theme.CheerUpLifeTheme
import com.cheeruplife.feature.search.components.SearchHistoryView
import com.cheeruplife.feature.search.components.SearchTitleBar

@Composable
internal fun SearchRoute(
    onNavigateBack: () -> Unit,
    onSearch: (String) -> Unit,
    viewModel: SearchViewModel = hiltViewModel(),
) {
    SearchScreen(
        historyList = emptyList(),
        onNavigateBack = onNavigateBack,
        onSearch = onSearch,
        onHistoryReset = { viewModel },
        onHistoryClear = { viewModel },
    )
}

@Composable
private fun SearchScreen(
    historyList: List<String>,
    onNavigateBack: () -> Unit,
    onSearch: (String) -> Unit,
    onHistoryReset: () -> Unit,
    onHistoryClear: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    val focusManager = LocalFocusManager.current
    val focusRequester = remember { FocusRequester() }
    LaunchedEffect(focusManager) {
        focusRequester.requestFocus()
    }
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .addFocusCleaner(focusManager),
    ) {
        stickyHeader {
            SearchTitleBar(
                focusManager = focusManager,
                focusRequester = focusRequester,
                onSearch = onSearch,
                onNavigateBack = onNavigateBack,
            )
        }
        item {
            SearchHistoryView(
                historyList = historyList,
                onHistoryReset = onHistoryReset,
                onSearch = onSearch,
                onHistoryClear = onHistoryClear,
            )
        }
    }
}

@Preview(name = "SearchScreen")
@Composable
private fun PreviewSearchScreen() {
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
        SearchScreen(
            historyList = testList,
            onSearch = {},
            onNavigateBack = {},
            onHistoryReset = {},
            onHistoryClear = {},
        )
    }
}