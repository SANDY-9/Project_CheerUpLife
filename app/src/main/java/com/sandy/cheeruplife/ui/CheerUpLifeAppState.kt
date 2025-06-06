package com.sandy.cheeruplife.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Stable
internal class CheerUpLifeAppState(
    val navController: NavHostController,
) {
    private val previousDestination = mutableStateOf<NavDestination?>(null)

    val currentDestination: NavDestination?
        @Composable get() {
            // Collect the currentBackStackEntryFlow as a state
            val currentEntry = navController.currentBackStackEntryFlow
                .collectAsState(initial = null)

            // Fallback to previousDestination if currentEntry is null
            return currentEntry.value?.destination.also { destination ->
                if (destination != null) {
                    previousDestination.value = destination
                }
            } ?: previousDestination.value
        }
}

@Composable
internal fun rememberHandsUpAppState(
    navController: NavHostController = rememberNavController(),
): CheerUpLifeAppState {
    return remember(
        navController,
    ) {
        CheerUpLifeAppState(
            navController,
        )
    }
}