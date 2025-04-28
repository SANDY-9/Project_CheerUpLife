package com.sandy.cheeruplife.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
        Greeting(
            name = "Android hello",
            modifier = modifier.padding(innerPadding)
        )
        CheerUpLifeNavGraph(
            modifier = modifier.padding(innerPadding),
            navController = appState.navController,
            startDestination = startDestination,
        )
    }
}

@Composable
private fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
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