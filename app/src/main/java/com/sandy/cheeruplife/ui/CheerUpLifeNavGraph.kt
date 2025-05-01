package com.sandy.cheeruplife.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.cheeruplife.feature.home.navigation.homeScreen
import com.cheeruplife.feature.recruit.navigation.recruitScreen
import com.cheeruplife.feature.search.navigation.searchScreen

@Composable
internal fun CheerUpLifeNavGraph(
    navController: NavHostController,
    startDestination: Any,
    modifier: Modifier = Modifier,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        homeScreen()
        searchScreen()
        recruitScreen()
    }
}