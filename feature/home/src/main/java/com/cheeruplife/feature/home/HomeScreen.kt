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
import com.cheeruplife.feature.home.components.HomeBannerView
import com.cheeruplife.feature.home.components.HomeInformationView
import com.cheeruplife.feature.home.components.HomeScheduleView
import com.cheeruplife.feature.home.components.HomeTitleBar

@Composable
internal fun HomeRoute(
    onClickNotification: () -> Unit,
    onClickCalendar: () -> Unit,
    onClickSearch: () -> Unit,
    onScheduleClick: () -> Unit,
    onScheduleItemClick: () -> Unit,
    onBannerItemClick: (String) -> Unit,
    onInformationMenuClick: (String) -> Unit,
    onWork24Click: () -> Unit,
    onSeoulJobClick: () -> Unit,
    onBannerClick: () -> Unit,
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
        onInformationMenuClick = onInformationMenuClick,
        onWork24Click = onWork24Click,
        onSeoulJobClick = onSeoulJobClick,
        onBannerClick = onBannerClick,
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
    onInformationMenuClick: (String) -> Unit,
    onWork24Click: () -> Unit,
    onSeoulJobClick: () -> Unit,
    onBannerClick: () -> Unit,
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
            HomeScheduleView(
                onScheduleClick = onScheduleClick,
                onDayOfWeekSelect = onDayOfWeekSelect,
                onScheduleItemClick = onScheduleItemClick,
            )
            Margin(height = Dimens.Margin30)
        }
        item {
            HomeInformationView(
                onBannerItemClick = onBannerItemClick,
                onInformationMenuClick = onInformationMenuClick,
                onWork24Click = onWork24Click,
                onSeoulJobClick = onSeoulJobClick,
            )
            Margin(height = Dimens.Margin30)
        }
        item {
            HomeBannerView(
                onBannerClick = onBannerClick,
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
            onInformationMenuClick = {},
            onWork24Click = {},
            onSeoulJobClick = {},
            onBannerClick = {},
        )
    }
}