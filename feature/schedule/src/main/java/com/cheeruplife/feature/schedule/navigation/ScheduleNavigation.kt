package com.cheeruplife.feature.schedule.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.cheeruplife.feature.schedule.ScheduleRoute
import kotlinx.serialization.Serializable

@Serializable object ScheduleRoute

fun NavController.navigateToSchedule(
    navOptions: NavOptions,
) {
    navigate(route = ScheduleRoute, navOptions)
}

fun NavGraphBuilder.scheduleScreen(
    onNavigateBack: () -> Unit = {},
) {
    composable<ScheduleRoute> {
        ScheduleRoute(
            onNavigateBack = onNavigateBack,
        )
    }
}