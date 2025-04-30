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
import com.cheeruplife.feature.home.components.HomeBannerContent
import com.cheeruplife.feature.home.components.HomeScheduleContent
import com.cheeruplife.feature.home.components.HomeTitleBar

@Composable
internal fun HomeRoute(
    onClickNotification: () -> Unit,
    onClickCalendar: () -> Unit,
    onClickSearch: () -> Unit,
    onScheduleClick: () -> Unit,
    onScheduleItemClick: () -> Unit,
    onBannerItemClick: (String) -> Unit,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    HomeScreen(
        onClickNotification = onClickNotification,
        onClickCalendar = onClickCalendar,
        onClickSearch = onClickSearch,
        onScheduleClick = onScheduleClick,
        onDayOfWeekSelect = { viewModel },
        onScheduleItemClick = onScheduleItemClick,
        onBannerItemClick = onBannerItemClick,
    )
}

@Composable
internal fun HomeScreen(
    onClickNotification: () -> Unit,
    onClickCalendar: () -> Unit,
    onClickSearch: () -> Unit,
    onScheduleClick: () -> Unit,
    onScheduleItemClick: () -> Unit,
    onDayOfWeekSelect: (Int) -> Unit,
    onBannerItemClick: (String) -> Unit,
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
            HomeScheduleContent(
                onScheduleClick = onScheduleClick,
                onDayOfWeekSelect = onDayOfWeekSelect,
                onScheduleItemClick = onScheduleItemClick,
            )
            Margin(height = Dimens.Margin30)
        }
        item {
            HomeBannerContent(
                onBannerItemClick = onBannerItemClick,
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
            onScheduleClick = {},
            onScheduleItemClick = {},
            onDayOfWeekSelect = {},
            onBannerItemClick = {},
        )
    }
}