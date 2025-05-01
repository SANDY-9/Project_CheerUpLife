package com.cheeruplife.feature.search.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.cheeruplife.feature.search.SearchRoute
import kotlinx.serialization.Serializable

@Serializable object SearchRoute

fun NavController.navigateToSearch(
    navOptions: NavOptions,
) {
    navigate(route = SearchRoute, navOptions)
}

fun NavGraphBuilder.searchScreen(

) {
    composable<SearchRoute> {
        SearchRoute(
        )
    }
}