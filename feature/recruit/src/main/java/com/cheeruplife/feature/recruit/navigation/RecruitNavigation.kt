package com.cheeruplife.feature.recruit.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.cheeruplife.feature.recruit.RecruitRoute
import kotlinx.serialization.Serializable

@Serializable object RecruitRoute

fun NavController.navigateToRecruit(
    navOptions: NavOptions,
) {
    navigate(route = RecruitRoute, navOptions)
}

fun NavGraphBuilder.recruitScreen(
    onNavigateBack: () -> Unit = {},
) {
    composable<RecruitRoute> {
        RecruitRoute(
            onNavigateBack = onNavigateBack,
        )
    }
}