package com.cheeruplife.feature.search

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.cheeruplife.core.designsystem.extension.addFocusCleaner
import com.cheeruplife.core.designsystem.theme.CheerUpLifeTheme
import com.cheeruplife.feature.search.components.SearchTitleBar

@Composable
internal fun SearchRoute(
    onNavigateBack: () -> Unit,
    onSearch: (String) -> Unit,
    viewModel: SearchViewModel = hiltViewModel(),
) {
    SearchScreen(
        onNavigateBack = onNavigateBack,
        onSearch = onSearch,
    )
}

@Composable
private fun SearchScreen(
    onNavigateBack: () -> Unit,
    onSearch: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    val focusManager = LocalFocusManager.current
    LaunchedEffect(focusManager) {
        focusManager.moveFocus(FocusDirection.Up)
    }
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .addFocusCleaner(focusManager),
    ) {
        stickyHeader {
            SearchTitleBar(
                focusManager = focusManager,
                onSearch = onSearch,
                onNavigateBack = onNavigateBack,
            )
        }
    }
}

@Preview(name = "SearchScreen")
@Composable
private fun PreviewSearchScreen() {
    CheerUpLifeTheme {
        SearchScreen(
            onSearch = {},
            onNavigateBack = {},
        )
    }
}