package com.sandy.cheeruplife.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController

@Composable
internal fun CheerUpLifeMainApp(
    appState: CheerUpLifeAppState,
    startDestination: Any,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
    ) { innerPadding ->
        CheerUpLifeNavGraph(
            modifier = modifier.padding(innerPadding),
            navController = appState.navController,
            startDestination = startDestination,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CheerUpLifeMainAppPreview() {
    CheerUpLifeMainApp(
        appState = CheerUpLifeAppState(
            navController = rememberNavController(),
        ),
        startDestination = "splash",
    )
}