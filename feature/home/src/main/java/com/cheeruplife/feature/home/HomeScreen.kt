package com.cheeruplife.feature.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.cheeruplife.feature.home.components.HomeTitleBar

@Composable
internal fun HomeRoute(
    onClickNotification: () -> Unit,
    onClickCalendar: () -> Unit,
    onClickSearch: () -> Unit,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    HomeScreen(
        onClickNotification = onClickNotification,
        onClickCalendar = onClickCalendar,
        onClickSearch = onClickSearch,
    )
}

@Composable
internal fun HomeScreen(
    onClickNotification: () -> Unit,
    onClickCalendar: () -> Unit,
    onClickSearch: () -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
    ) {
        stickyHeader {
            HomeTitleBar(
                onClickNotification = onClickNotification,
                onClickCalendar = onClickCalendar,
                onClickSearch = onClickSearch,
            )
        }
    }
}

@Preview(name = "HomeScreen")
@Composable
private fun PreviewHomeScreen() {
    HomeScreen(
        onClickNotification = {},
        onClickCalendar = {},
        onClickSearch = {},
    )
}