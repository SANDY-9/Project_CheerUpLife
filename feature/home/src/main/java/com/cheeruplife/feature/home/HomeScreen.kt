package com.cheeruplife.feature.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.cheeruplife.core.designsystem.common.Dimens
import com.cheeruplife.core.designsystem.common.Margin
import com.cheeruplife.core.designsystem.theme.CheerUpLifeTheme
import com.cheeruplife.feature.home.components.HomeBookmarkContent
import com.cheeruplife.feature.home.components.HomeTitleBar

@Composable
internal fun HomeRoute(
    onClickNotification: () -> Unit,
    onClickCalendar: () -> Unit,
    onClickSearch: () -> Unit,
    onBookmarkClick: () -> Unit,
    onBookmarkItemClick: (String) -> Unit,
    onBookmarkEmptyClick: () -> Unit,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    HomeScreen(
        onClickNotification = onClickNotification,
        onClickCalendar = onClickCalendar,
        onClickSearch = onClickSearch,
        onBookmarkClick = onBookmarkClick,
        onBookmarkItemClick = onBookmarkItemClick,
        onBookmarkEmptyClick = onBookmarkEmptyClick,
    )
}

@Composable
internal fun HomeScreen(
    onClickNotification: () -> Unit,
    onClickCalendar: () -> Unit,
    onClickSearch: () -> Unit,
    onBookmarkClick: () -> Unit,
    onBookmarkItemClick: (String) -> Unit,
    onBookmarkEmptyClick: () -> Unit,
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
        item {
            HomeBookmarkContent(
                isBookmarkNotEmpty = true,
                onBookmarkClick = onBookmarkClick,
                onBookmarkItemClick = onBookmarkItemClick,
                onBookmarkEmptyClick = onBookmarkEmptyClick,
            )
            Margin(height = Dimens.Margin30)
        }
    }
}

@Preview(name = "HomeScreen")
@Composable
private fun PreviewHomeScreen() {
    CheerUpLifeTheme {
        HomeScreen(
            onClickNotification = {},
            onClickCalendar = {},
            onClickSearch = {},
            onBookmarkClick = {},
            onBookmarkItemClick = {},
            onBookmarkEmptyClick = {},
        )
    }
}