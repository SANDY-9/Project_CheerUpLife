package com.cheeruplife.feature.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.cheeruplife.feature.home.HomeRoute
import kotlinx.serialization.Serializable

@Serializable object HomeRoute

fun NavController.navigateToHome(
    navOptions: NavOptions,
) {
    navigate(route = HomeRoute, navOptions)
}

fun NavGraphBuilder.homeScreen(
    onClickNotification: () -> Unit = {},
    onClickCalendar: () -> Unit = {},
    onClickSearch: () -> Unit = {},
    onScheduleClick: () -> Unit = {},
    onScheduleItemClick: () -> Unit = {},
    onBannerItemClick: (String) -> Unit = {},
    onInformationMenuClick: (String) -> Unit = {},
    onWork24Click: () -> Unit = {},
    onSeoulJobClick: () -> Unit = {},
    onBannerClick: () -> Unit = {},
    onRecruitClick: () -> Unit = {},
    onRecruitItemClick: (String) -> Unit = {},
) {
    composable<HomeRoute> {
        HomeRoute(
            onClickNotification = onClickNotification,
            onClickCalendar = onClickCalendar,
            onClickSearch = onClickSearch,
            onScheduleClick = onScheduleClick,
            onScheduleItemClick = onScheduleItemClick,
            onBannerItemClick = onBannerItemClick,
            onInformationMenuClick = onInformationMenuClick,
            onWork24Click = onWork24Click,
            onSeoulJobClick = onSeoulJobClick,
            onBannerClick = onBannerClick,
            onRecruitClick = onRecruitClick,
            onRecruitItemClick = onRecruitItemClick,
        )
    }
}